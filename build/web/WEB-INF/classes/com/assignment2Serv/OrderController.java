/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2Serv;

import com.assignment2.Menu;
import com.assignment2.Order;
import com.assignment2data.OrdersDB;
import com.assignment2data.TablesDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class OrderController extends HttpServlet {

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
            out.println("<title>Servlet OrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
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

        ServletContext sc = getServletContext();
        //  HttpSession session=request.getSession();
        Menu menu1 = new Menu(1, "Ready to order", "Non-Alcoholic", 20.3);
        Menu menu2 = new Menu(2,"Menu","Non-Alcoholic",2.7);
        Menu menu3 = new Menu(3,"Water","Non-Alcoholic",2.7);
        Menu menu4 = new Menu(4,"Bread","Non-Alcoholic",2.7);
        Menu menu5 = new Menu(5,"SilverWare","Non-Alcoholic",2.7);
        Menu menu6 = new Menu(6,"Napkins","Non-Alcoholic",2.9);
        Menu menu7 = new Menu(7,"Pepsi","Non-Alcoholic",4.5);
        Menu menu8= new Menu(8,"Juice","Non-Alcoholic",8.5);
        Menu menu9 = new Menu(9,"Alcohol","Alcoholic",7.9);
        Menu menu10=new Menu(10,"Desserts","Non-Alcholic",4.4 );
        Menu menu11 = new Menu(11,"DND","Non-Alcoholic",0.5);
        Menu menu12= new Menu(12,"Man","Non-Alcoholic",2.5);
        
        List<Order> order = new ArrayList<Order>();
        List<Menu> menuList = new ArrayList<Menu>();
        List<Menu> menuList1= new ArrayList<Menu>();

        menuList.add(menu1);
        menuList.add(menu2);
        menuList.add(menu3);
        menuList.add(menu4);
        menuList.add(menu5);
        menuList.add(menu6);
        menuList.add(menu7);
        menuList.add(menu8);
        menuList.add(menu9);
        menuList.add(menu10);
        menuList.add(menu11);
        menuList.add(menu12);
        

        String url = null;
       String message="";
        String action = request.getParameter("action").toString();

        HttpSession session = request.getSession();
        ArrayList<Order> ordernew = null;
        if(session.getAttribute("order")!=null)
        ordernew=(ArrayList<Order>) session.getAttribute("order");
//            Order ordernew=null;

//        if (ordernew == null) {
//            ordernew = new ArrayList<Order>();
//        }

        

        if (action.equals("additem")) {
            String menunumber = request.getParameter("param1").toString();
            boolean isExists = false;
            if (ordernew != null) {
                //Order o = new Order();
                for (Order o : ordernew) {
                    if (menunumber.equals(String.valueOf(o.getMenuNumber()))) {
                        isExists = true;
                        o.setMenuNumber(Integer.parseInt(menunumber));
                        o.setQuantity(o.getQuantity() + 1);

                        //o.setMenuList(menuList);
                    }
                    order.add(o);
                }
                 ArrayList<Menu> menuL=new ArrayList<Menu>();
                    OrdersDB orderDB=new OrdersDB();
                    menuL= orderDB.selectMenus();
                   
                if (!isExists) {
                    
                    
                    Order o = new Order();
                    o.setQuantity(1);
                    o.setMenuNumber(Integer.parseInt(menunumber));

                    for (Menu m1 : menuL) {
                        if (m1.getMenuNumber() == (Integer.parseInt(menunumber))) {
                            menuList1.add(m1);
                        }
                    }

                    o.setMenuList(menuList1);
                    order.add(o);
                }

            }else{
                ordernew = new ArrayList<Order>();
                Order o=new Order();
                o.setQuantity(1);
                 ArrayList<Menu> menuL=new ArrayList<Menu>();
                    OrdersDB orderDB=new OrdersDB();
                    menuL= orderDB.selectMenus();
                   
                o.setMenuNumber(Integer.parseInt(menunumber));
                for (Menu m1 : menuL) {
                        if (m1.getMenuNumber() == (Integer.parseInt(menunumber))) {
                            menuList1.add(m1);
                        }
                    }

                    o.setMenuList(menuList1);
                    order.add(o);
                
            }
            
            url = "/cart.jsp"; 

                session.setAttribute("order", order);
            }
        
        if(action.equals("updateItem")){
            
          String item=request.getParameter("item")==null?"":request.getParameter("item");
          String quantity=request.getParameter("quantity1")==null?"":request.getParameter("quantity1");
            
           if(!item.equals("") && !quantity.equals("")){
               int quant=Integer.parseInt(quantity);
               for(Order o:ordernew){
                   for(Menu m:o.getMenuList()){
                       if(m.getMenuNumber()==Integer.parseInt(item)){
                           o.setQuantity(quant);
                       }
                   }
               }
               
               
               
                session.setAttribute("order", ordernew);
                 url = "/cart.jsp"; 
           }
            
            
        }

         if(action.equals("deleteItem")){
            
          String itemdelete=request.getParameter("itemdelete")==null?"":request.getParameter("itemdelete");
         
          ArrayList<Order> ordernewList=new ArrayList<Order>();
            
           if(!itemdelete.equals("")){
               
               for(Order o:ordernew){
                   for(Menu m:o.getMenuList()){
                       if(m.getMenuNumber()==Integer.parseInt(itemdelete)){
                         //ordernew.remove(o);
                           //m.setPrice(quant*m.getPrice());
                       }
                       else{
                           ordernewList.add(o);
                       }
                   }
               }
                session.setAttribute("order", ordernewList);
                 url = "/cart.jsp"; 
           }
           
           
            
        }
         
        if(action.equals("getorder")){
            
        } 
       if(action.equals("checkout")){
            String Tablenumber=request.getParameter("tablenumber");
              
            
            
           if(ordernew.isEmpty()){
                 url = "/order.jsp"; 
           }
           else{
            
               
             
             ordernew=(ArrayList<Order>) session.getAttribute("order");
             double total=0.0;
             
             for(Order orde:ordernew){
                 int quant= orde.getQuantity();
                 for(Menu menu:orde.getMenuList()){
                    double price= menu.getPrice();
                    total=quant*price+total;
                 }
                 
             }
              
            session.setAttribute("total",total); 
           url = "/confirm.jsp"; 
              
           }
           
       }  
         if(action.equals("confirm")){
             
               Cookie[] cookies = request.getCookies();
             String cookiename = "cookie1";
             String cookievalue = "";
             for(Cookie cookie : cookies){
                 if(cookiename.equals(cookie.getName())){
                     cookievalue = cookie.getValue();
                 }
             }
             System.out.println("checkout cookie value:"+ cookievalue);
            String tno = cookievalue;
             
             ordernew=(ArrayList<Order>) session.getAttribute("order");
             OrdersDB orderDB=new OrdersDB();
             
             for(Order ord: ordernew){
             orderDB.insertOrder(ord, tno);
             }
             
             
             TablesDB tableDB=new TablesDB();
             
             tableDB.updateTable(tno);
             
             Double total=(Double)session.getAttribute("total");
             OrdersDB.insertAmount(tno,total);
             
          
             
           message="Order placed";
            session.setAttribute("message", message);
            url="/main.jsp";
        }   
      
       if(action.equals("shopping")){
           
           
           if(ordernew.isEmpty()){
                 url = "/order.jsp"; 
           }
           else{
              url = "/order.jsp"; 
           }
        
        
           
            
        }  
       
       if(action.equals("order")){
            url="/order.jsp";
            
            
            
            
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
