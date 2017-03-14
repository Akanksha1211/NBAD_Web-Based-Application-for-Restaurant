/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2data;

import com.assignment2.Menu;
import com.assignment2.Order;
import com.assignment2.RTable;
import com.assignment2.TableAmount;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author aavha
 */
public class OrdersDB {
    
    
        
        public static ArrayList<Menu> selectMenus() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        ArrayList<Menu> menuList=new ArrayList<Menu>();

        String query = "SELECT * FROM menu";
        
        try {
            ps = connection.prepareStatement(query);
             rs = ps.executeQuery();
              Menu menu=null;
            while (rs.next()) {
               menu= new Menu();
                menu.setMenuNumber(Integer.parseInt(rs.getString("MenuNumber")));
                menu.setMenuType(rs.getString("MenuType"));
                menu.setPrice(Double.parseDouble(rs.getString("Price")));
                menu.setMenuItem(rs.getString("MenuItem"));
                
                
                menuList.add(menu);
            }
            
            return menuList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
   
       public static Menu getMenuDetails(int number) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        String query = "SELECT * FROM menu "
                + "WHERE MenuNumber = ?"; 
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(number));
             rs = ps.executeQuery();
              Menu menu=null;
            if (rs.next()) {
                menu= new Menu();
                menu.setMenuNumber(Integer.parseInt(rs.getString("MenuNumber")));
                menu.setMenuType(rs.getString("MenuType"));
                menu.setPrice(Double.parseDouble(rs.getString("Price")));
                menu.setMenuItem(rs.getString("MenuItem"));
            }
            
            return menu;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
         
        public static ArrayList<Order> getOrders() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        ArrayList<Order> orderList=new ArrayList<Order>();

        //String query = "SELECT orders.OrderID,menu.MenuNumber,ordersdetails.Quantity,orders.TableNumber,MenuItem,MenuType,Price FROM orders,ordersdetails,menu where orders.OrderID=ordersdetails.OrderID and menu.MenuNumber=ordersdetails.MenuNumber";
       // query= "SELECT orders.OrderID,GROUP_CONCAT(menu.MenuNumber) MenuNumber,SUM(ordersdetails.Quantity) Quantity,sum(price) price,"+
         //       "TableNumber,GROUP_CONCAT(MenuItem) MenuItem,GROUP_CONCAT(MenuType)  MenuType "+
           //     "FROM `orders`,`ordersdetails`,`menu` "+
             //   "where orders.OrderID=ordersdetails.OrderID and menu.MenuNumber=ordersdetails.MenuNumber "+
               // "group by  orders.OrderID,TableNumber";
           
              String query = "SELECT * FROM orders";
            
        try {
            ps = connection.prepareStatement(query);
             rs = ps.executeQuery();
             
             Order order=null;
             
            while (rs.next()) {
               ArrayList<Menu> menuList=new ArrayList<Menu>(); 
               order= new Order();
               order.setOrderId(rs.getString("OrderID"));
                order.setTNumber(rs.getString("TableNumber"));
                order.setOrderTime(rs.getString("OrderTime"));
                order.setProcessingTime(rs.getString("ProcessTime"));
                order.setResponseTime(rs.getString("ResponseTime"));
                order.setMenuNumber(Integer.parseInt((rs.getString("MenuNumber"))));
                order.setQuantity(Integer.parseInt(rs.getString("Quantity")));
                order.setProcessorNumber(Double.parseDouble(rs.getString("ProcessorNumber")));
                order.setServerNumber(Double.parseDouble(rs.getString("ServerNumber")));
//              
               Integer menuNumber= order.getMenuNumber();
               
                Menu menu= getMenuDetails(menuNumber);
                 menuList.add(menu);
                 order.setMenuList(menuList);
                 orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        }
        
        
        
        
          public static ArrayList<TableAmount> getAmount() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        ArrayList<TableAmount> amountList=new ArrayList<TableAmount>();
           
              String query = "SELECT * FROM usertableamount";
            
        try {
            ps = connection.prepareStatement(query);
             rs = ps.executeQuery();
             
             TableAmount amount=null;
             
            while (rs.next()) {
               amount= new TableAmount();
               amount.setTNumber(rs.getString("TableNumber"));
                amount.setAmount(Double.parseDouble(rs.getString("Amount")));
                amountList.add(amount);
                }
            return amountList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        }
        
      
       

        public static void insertOrder(Order order, String Tablenumber) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String id1="232";
        String id2="123";

        String query
                = "INSERT INTO orders (OrderID, TableNumber, OrderTime, ProcessTime, ResponseTime, MenuNumber, Quantity, ProcessorNumber, ServerNumber) "
                + "VALUES (Null, ?, Now(), Now(), Now(), ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Tablenumber);
            ps.setString(2, String.valueOf(order.getMenuNumber()));
            ps.setString(3, String.valueOf(order.getQuantity()));
            ps.setString(4, String.valueOf(id1));
            ps.setString(5, String.valueOf(id2));
            
            
           ps.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
        
         public static void insertAmount(String Tablenumber,Double amount) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String id1="232";
        String id2="123";

        String query
                = "INSERT INTO usertableamount (TableNumber, Amount) "
                + "VALUES (?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Tablenumber);
            ps.setString(2, String.valueOf(amount));
            
            
           ps.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
      public static void insertOrderDetails(Order order, int Tablenumber) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO ordersdetails (OrderID, MenuNumber, Quantity) "
                + "VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(Tablenumber));
            ps.setString(2, String.valueOf(order.getMenuNumber()));
            ps.setString(3, String.valueOf(order.getQuantity()));
            
           ps.executeUpdate();
            

    
        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
      
      public static int updateTableStatusAll(String tno) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query= "UPDATE rtables SET TableStatus =? WHERE TableNumber = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "Free");
            ps.setString(2, tno);
            

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

      public static int deleteOrders() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        TablesDB tablesDB = new TablesDB();
        ArrayList<RTable> tables = new ArrayList<RTable>();
                    
        tables = tablesDB.getTables();
        
        for(RTable rt:tables){
            String tnumber=rt.getTNumber();
            updateTableStatusAll(tnumber);
        }
      
        String query = "DELETE FROM orders";
        try {
            ps = connection.prepareStatement(query);
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

       public static int deleteOrder(String OrderId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        TablesDB tablesDB = new TablesDB();
        ArrayList<RTable> tables = new ArrayList<RTable>();
                    
        tables = tablesDB.getTables();
        
        for(RTable rt:tables){
            String tnumber=rt.getTNumber();
            updateTableStatusAll(tnumber);
        }
      
        String query = "DELETE FROM orders where OrderID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, OrderId);
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

      public static Order getOrder(String OrderId, String filepath) throws ParseException {
        Order order=new Order();
        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String orderNumber = t.nextToken();
                if(orderNumber.equalsIgnoreCase(OrderId)){
                
                    String number=t.nextToken();
                    String orderTime=t.nextToken();
                    String processTime=t.nextToken();
                    String responseTime=t.nextToken();
                    String menuNumber=t.nextToken();
                    String quantity=t.nextToken();
                    String processorNumber =t.nextToken();
                    String serverNumber =t.nextToken();
                    
                   SimpleDateFormat df = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
                   Date date1 = df.parse(orderTime);
                   Date date2= df.parse(processTime);
                   Date date3 = df.parse(responseTime);
                   

                     order.setMenuNumber(Integer.parseInt(menuNumber));
                     order.setTNumber(number);
                     order.setOrderId(OrderId);
                     order.setOrderTime(orderTime);
                     order.setProcessingTime(orderTime);
                     order.setProcessorNumber(Double.parseDouble(processorNumber));
                     order.setServerNumber(Double.parseDouble(serverNumber));
                     order.setQuantity(Integer.parseInt(quantity));
                     order.setResponseTime(orderTime);
                   
                line = in.readLine();}
                
            }
            in.close();
            return order;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
      }
      
       public static List<Order> geTableOrders(String TNumber, String filepath) throws ParseException {
        List<Order> orderList=new ArrayList<Order>();
        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                Order order=new Order();
                String orderNumber = t.nextToken();
                String number=t.nextToken();
                if(number.equalsIgnoreCase(TNumber)){
                    String orderTime=t.nextToken();
                    String processTime=t.nextToken();
                    String responseTime=t.nextToken();
                    String menuNumber=t.nextToken();
                    String quantity=t.nextToken();
                    String processorNumber =t.nextToken();
                    String serverNumber =t.nextToken();
                    
                   SimpleDateFormat df = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
                   Date date1 = df.parse(orderTime);
                   Date date2= df.parse(processTime);
                   Date date3 = df.parse(responseTime);
                   

                     order.setMenuNumber(Integer.parseInt(menuNumber));
                     order.setTNumber(number);
                     order.setOrderId(orderNumber);
                     order.setOrderTime(orderTime);
                     order.setProcessingTime(orderTime);
                     order.setProcessorNumber(Double.parseDouble(processorNumber));
                     order.setServerNumber(Double.parseDouble(serverNumber));
                     order.setQuantity(Integer.parseInt(quantity));
                     order.setResponseTime(orderTime);
                   
                     orderList.add(order);
                line = in.readLine();}
                
            }
            in.close();
            return orderList;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
   
    }
      
      
      
      
      
      
      
}
