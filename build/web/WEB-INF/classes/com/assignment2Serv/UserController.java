/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2Serv;

import com.assignment2.Menu;
import com.assignment2.Order;
import com.assignment2.Password;
import com.assignment2.RTable;
import com.assignment2.TableAmount;
import com.assignment2.User;
import com.assignment2.UserTable;
import com.assignment2data.OrdersDB;
import com.assignment2data.PasswordUtil;
import static com.assignment2data.PasswordUtil.hashPassword;
import com.assignment2data.TablesDB;
import com.assignment2data.UserDB;
import com.assignment2data.UserData;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aavha
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String abc="hi";
        String action = request.getParameter("action");
        String url="";
        
        if(abc.equals("hi")){
             String serverInfo = request.getServerName() + " :: " + request.getServerPort();
        
        Cookie cookie1 = new Cookie("host", request.getServerName());
        cookie1.setMaxAge(60 * 60 * 24 * 365 * 2); 
        cookie1.setPath("/");                      
        response.addCookie(cookie1);
        
        Cookie cookie2 = new Cookie("port", String.valueOf(request.getServerPort()));
        cookie2.setMaxAge(60 * 60 * 24 * 365 * 2); 
        cookie2.setPath("/");                      
        response.addCookie(cookie2);
        
        
            Cookie cookie = new Cookie("server", serverInfo);
            
            log("Cookie"+cookie1.getValue());
            response.addCookie(cookie);
            response.addCookie(cookie);
            url="/main.jsp";
            
       
        }
  
        ServletContext sc = getServletContext();
        
        
        
        HttpSession session = request.getSession();
       // String url = "/main.jsp";
        String msg;
        User user=null;
        
        String username=request.getParameter("username");
        String password=request.getParameter("password");
            
        if(action==null){
            url="/main.jsp";
        }
        
        if(action.equals("deleteorder")){
           String orderId= request.getParameter("param1");
           OrdersDB.deleteOrder(orderId);
           
           List<Order> orderList= OrdersDB.getOrders();
           session.setAttribute("orderList", orderList);
           
           url="/wait1.jsp";
            
        }
        
        if(action.equals("deleteorderbar")){
           String orderId= request.getParameter("param1");
           OrdersDB.deleteOrder(orderId);
           
           List<Order> orderList= OrdersDB.getOrders();
           session.setAttribute("orderList", orderList);
           
           url="/barattend.jsp";
            
        }
        if(action.equals("login")){
            
          UserDB userDB=new UserDB();
          Password pass =userDB.getPassword(username);
          String passwordhash=null;
          
          PasswordUtil util=new PasswordUtil();
            try {
               String salt= pass.getSalt();
               passwordhash=util.hashPassword(password+salt);
               log("passwordHash"+ passwordhash);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
   
           Boolean value=userDB.validateUser(passwordhash,username);
          log("Value"+ value);
          
       
          if(value){ 
             user=userDB.getUser(username);
             String role = userDB.getUserRole(username);
             user.setRole(role);
             session.setAttribute("user", user);
             
              log("Role "+ role);
              
              if(role.equals("Manager")){
                  
                  TablesDB tablesDB = new TablesDB();
                
                List<UserTable> usertable=tablesDB.selectUserTable(username);
                
                
                    session.setAttribute("usertableList", usertable);
                
                    ArrayList<RTable> tables = new ArrayList<RTable>();
                    ArrayList<RTable> tableFront=new ArrayList<RTable>();
                    ArrayList<RTable> tableMiddle=new ArrayList<RTable>();
                    ArrayList<RTable> tableEnd=new ArrayList<RTable>();


                    tables = tablesDB.getTables();
                    

                    for(RTable rtable:tables){
                        if((rtable.getLocation()).equals("Front")){
                        tableFront.add(rtable);
                        }
                    }
                    for(RTable rtable1:tables){
                        if((rtable1.getLocation()).equals("Middle")){
                        tableMiddle.add(rtable1);
                        }
                    }
                    for(RTable rtable2:tables){
                        if((rtable2.getLocation()).equals("End")){
                        tableEnd.add(rtable2);
                        }
                    }  
                        
                 
                   List<Order> orderList= OrdersDB.getOrders();
               
                   
                       //session.setAttribute("orderList", orderList);
                       session.setAttribute("tableFront", tableFront);
                       session.setAttribute("tableMiddle", tableMiddle);
                       session.setAttribute("tableEnd", tableEnd);
            
                       

                  url="/manager.jsp";   
              }

              else if(role.equals("Wait")){
                  
                TablesDB tablesDB = new TablesDB();
                
                List<UserTable> usertable=tablesDB.selectUserTable(username);
                
                
                session.setAttribute("usertableList", usertable);
                
                    ArrayList<RTable> tables = new ArrayList<RTable>();
                    ArrayList<RTable> tableFront=new ArrayList<RTable>();
                    ArrayList<RTable> tableMiddle=new ArrayList<RTable>();
                    ArrayList<RTable> tableEnd=new ArrayList<RTable>();


                    tables = tablesDB.getTables();
                    

                    for(RTable rtable:tables){
                        if((rtable.getLocation()).equals("Front")){
                        tableFront.add(rtable);
                        }
                    }
                    for(RTable rtable1:tables){
                        if((rtable1.getLocation()).equals("Middle")){
                        tableMiddle.add(rtable1);
                        }
                    }
                    for(RTable rtable2:tables){
                        if((rtable2.getLocation()).equals("End")){
                        tableEnd.add(rtable2);
                        }
                    }  
                        
                 
                   
                    List<Order> orderList= OrdersDB.getOrders();
               
                    List<TableAmount> tableamountList= OrdersDB.getAmount();
                    
                       session.setAttribute("amountList", tableamountList);
                       session.setAttribute("orderList", orderList);
                       session.setAttribute("tableFront", tableFront);
                       session.setAttribute("tableMiddle", tableMiddle);
                       session.setAttribute("tableEnd", tableEnd);
            
                  url="/wait1.jsp";
              }
              else if(role.equals("Host")){
                  
                  TablesDB tablesDB = new TablesDB();
                
                List<UserTable> usertable=tablesDB.selectUserTable(username);
                
                
                    session.setAttribute("usertableList", usertable);
                
                    ArrayList<RTable> tables = new ArrayList<RTable>();
                    ArrayList<RTable> tableFront=new ArrayList<RTable>();
                    ArrayList<RTable> tableMiddle=new ArrayList<RTable>();
                    ArrayList<RTable> tableEnd=new ArrayList<RTable>();


                    tables = tablesDB.getTables();
                    

                    for(RTable rtable:tables){
                        if((rtable.getLocation()).equals("Front")){
                        tableFront.add(rtable);
                        }
                    }
                    for(RTable rtable1:tables){
                        if((rtable1.getLocation()).equals("Middle")){
                        tableMiddle.add(rtable1);
                        }
                    }
                    for(RTable rtable2:tables){
                        if((rtable2.getLocation()).equals("End")){
                        tableEnd.add(rtable2);
                        }
                    }  
                        
                 
                   List<Order> orderList= OrdersDB.getOrders();
               
                   
                       //session.setAttribute("orderList", orderList);
                       session.setAttribute("tableFront", tableFront);
                       session.setAttribute("tableMiddle", tableMiddle);
                       session.setAttribute("tableEnd", tableEnd);
            
                  
                  
                  url="/host.jsp";
              }
              else if(role.equals("Busboy")){
                  TablesDB tablesDB = new TablesDB();
                
                List<UserTable> usertable=tablesDB.selectUserTable(username);
                
                
                    session.setAttribute("usertableList", usertable);
                
                    ArrayList<RTable> tables = new ArrayList<RTable>();
                    ArrayList<RTable> tableFront=new ArrayList<RTable>();
                    ArrayList<RTable> tableMiddle=new ArrayList<RTable>();
                    ArrayList<RTable> tableEnd=new ArrayList<RTable>();


                    tables = tablesDB.getTables();
                    

                    for(RTable rtable:tables){
                        if((rtable.getLocation()).equals("Front")){
                        tableFront.add(rtable);
                        }
                    }
                    for(RTable rtable1:tables){
                        if((rtable1.getLocation()).equals("Middle")){
                        tableMiddle.add(rtable1);
                        }
                    }
                    for(RTable rtable2:tables){
                        if((rtable2.getLocation()).equals("End")){
                        tableEnd.add(rtable2);
                        }
                    }  
                        
                 
                   List<Order> orderList= OrdersDB.getOrders();
               
                   
                       //session.setAttribute("orderList", orderList);
                       session.setAttribute("tableFront", tableFront);
                       session.setAttribute("tableMiddle", tableMiddle);
                       session.setAttribute("tableEnd", tableEnd);
            
                       
                  
                  url="/busyboy.jsp";
              }
              else if(role.equals("Barattend")){
                  
                 TablesDB tablesDB = new TablesDB();
                
                List<UserTable> usertable=tablesDB.selectUserTable(username);
                
                
                session.setAttribute("usertableList", usertable);
                
                    ArrayList<RTable> tables = new ArrayList<RTable>();
                    ArrayList<RTable> tableFront=new ArrayList<RTable>();
                    ArrayList<RTable> tableMiddle=new ArrayList<RTable>();
                    ArrayList<RTable> tableEnd=new ArrayList<RTable>();


                    tables = tablesDB.getTables();
                    

                    for(RTable rtable:tables){
                        if((rtable.getLocation()).equals("Front")){
                        tableFront.add(rtable);
                        }
                    }
                    for(RTable rtable1:tables){
                        if((rtable1.getLocation()).equals("Middle")){
                        tableMiddle.add(rtable1);
                        }
                    }
                    for(RTable rtable2:tables){
                        if((rtable2.getLocation()).equals("End")){
                        tableEnd.add(rtable2);
                        }
                    }  
                        
                 
                   List<Order> orderList= OrdersDB.getOrders();
                    List<TableAmount> tableamountList= OrdersDB.getAmount();
                    
                       session.setAttribute("amountList", tableamountList);
                      
                   
                       session.setAttribute("orderList", orderList);
                       session.setAttribute("tableFront", tableFront);
                       session.setAttribute("tableMiddle", tableMiddle);
                       session.setAttribute("tableEnd", tableEnd);
            
                  url="/barattend.jsp";
              }
             
              
              
          }
          else{
              msg="Invalid Credentials";
              request.setAttribute("message", msg);
              url="/login.jsp";
          }
          
          user=userDB.getUser(username);  
        }
        else if(action.equals("logout")){
            
            if(session.getAttribute("user")!=null){
               session.invalidate();
            url="/login.jsp"; 
            }else{
              url="/login.jsp";  
            }
            
        }
        else if(action.equals("busyboy")){
           url="/buslogin.jsp";
        }
        else if(action.equals("buslogin")){
           String password1 = request.getParameter("password");
           log("passowrd"+password1);
           if(password1.equals(UserData.code)){
                TablesDB tablesDB = new TablesDB();
                
                List<UserTable> usertable=tablesDB.selectUserTable(username);
                
                
                    session.setAttribute("usertableList", usertable);
                
                    ArrayList<RTable> tables = new ArrayList<RTable>();
                    ArrayList<RTable> tableFront=new ArrayList<RTable>();
                    ArrayList<RTable> tableMiddle=new ArrayList<RTable>();
                    ArrayList<RTable> tableEnd=new ArrayList<RTable>();


                    tables = tablesDB.getTables();
                    

                    for(RTable rtable:tables){
                        if((rtable.getLocation()).equals("Front")){
                        tableFront.add(rtable);
                        }
                    }
                    for(RTable rtable1:tables){
                        if((rtable1.getLocation()).equals("Middle")){
                        tableMiddle.add(rtable1);
                        }
                    }
                    for(RTable rtable2:tables){
                        if((rtable2.getLocation()).equals("End")){
                        tableEnd.add(rtable2);
                        }
                    }  
                        
                 
                   List<Order> orderList= OrdersDB.getOrders();
               
                   
                       //session.setAttribute("orderList", orderList);
                       session.setAttribute("tableFront", tableFront);
                       session.setAttribute("tableMiddle", tableMiddle);
                       session.setAttribute("tableEnd", tableEnd);
            
                       
               
               
               url="/busyboy.jsp";
           }
           else{
               url="/main.jsp";
           }
        }
        
         sc.getRequestDispatcher(url)
                .forward(request, response);

        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
