/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2data;

import com.assignment2.RTable;
import com.assignment2.User;
import com.assignment2.UserTable;
import static com.assignment2data.OrdersDB.updateTableStatusAll;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author aavha
 */
public class TablesDB {
    
     private ArrayList<RTable> items;

    public TablesDB() {
        items = new ArrayList<RTable>();
    }

    public ArrayList<RTable> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    
    public static int deletetUserTableOrders() {
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
      
        String query = "DELETE FROM usertable";
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
 
    
    public static int insertTable(RTable roleTable) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO rtables (TableNumber, Location, Capacity, TableStatus) "
                + "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, roleTable.getTNumber());
            ps.setString(2, roleTable.getLocation());
            ps.setString(3, String.valueOf(roleTable.getCapacity()));
            ps.setString(4, roleTable.getTStatus());
            
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
     public static int insertUserTable(String username, String tablenumber) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO usertable (UserName, TableNumber) "
                + "VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, tablenumber);
            
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
   
     
     public static ArrayList<RTable> getTables() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<RTable> tableList=new ArrayList<RTable>();

        String query = "SELECT * FROM rtables";
        
        try {
            ps = connection.prepareStatement(query);
             rs = ps.executeQuery();
              RTable rtable=null;
            while (rs.next()) {
               rtable= new RTable();
               rtable.setCapacity(Integer.parseInt(rs.getString("Capacity")));
               rtable.setLocation(rs.getString("Location"));
               rtable.setTNumber(rs.getString("TableNumber"));
               rtable.setTStatus(rs.getString("TableStatus"));
               
                tableList.add(rtable);
            }
            
            return tableList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
   
     public static ArrayList<UserTable> selectUserTable(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<UserTable> tableList=new ArrayList<UserTable>();

         String query = "SELECT * FROM usertable "
                + "WHERE UserName = ?"; 
      
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
             
             rs = ps.executeQuery();
              UserTable utable=null;
            while (rs.next()) {
               utable= new UserTable();
               utable.setUserName(rs.getString("UserName"));
               utable.setTNumber(rs.getString("TableNumber"));
               
                tableList.add(utable);
            }
            
            return tableList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
     
     public static ArrayList<RTable> getFreeTables() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<RTable> tableList=new ArrayList<RTable>();

        String query = "SELECT * FROM rtables where TableStatus='Free'";
        
        try {
            ps = connection.prepareStatement(query);
             rs = ps.executeQuery();
              RTable rtable=null;
            while (rs.next()) {
               rtable= new RTable();
               rtable.setCapacity(Integer.parseInt(rs.getString("Capacity")));
               rtable.setLocation(rs.getString("Location"));
               rtable.setTNumber(rs.getString("TableNumber"));
               rtable.setTStatus(rs.getString("TableStatus"));
               
                tableList.add(rtable);
            }
            
            return tableList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
   
    public static int updateTable(String tno) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

      //  String query = "UPDATE rtables SET "
       //         + "TableStatus = ?, "
        //        + "WHERE TableNumber = ?";
        
        String query= "UPDATE rtables SET TableStatus =? WHERE TableNumber = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "Occu");
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

     
     public static RTable getTableInfo(String TableNumber, String filepath) {
        try {
            File file = new File(filepath);
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String TableNumber1 = t.nextToken();
                if (TableNumber1.equalsIgnoreCase(TableNumber)) {
                    String tableStatus = t.nextToken();
                    String capacity=t.nextToken();
                    String location=t.nextToken();
                    
                    
                    RTable roleTable=new RTable();
                    
                    roleTable.setCapacity(Integer.parseInt(capacity));
                    roleTable.setLocation(location);
                    roleTable.setTNumber(TableNumber);
                    roleTable.setTStatus(tableStatus);
                    
                    
                    in.close();
                    return roleTable;
                }
                line = in.readLine();
            }
            in.close();
            return null;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
     
     
      public static ArrayList<RTable> getTables(String filepath) {
        ArrayList<RTable> roleList=new ArrayList<RTable>();
        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                
                     String TableNumber = t.nextToken();
                    String tableStatus = t.nextToken();
                    String capacity=t.nextToken();
                    String location=t.nextToken();
                    
                    
                    RTable roleTable=new RTable();
                    
                    roleTable.setCapacity(Integer.parseInt(capacity));
                    roleTable.setLocation(location);
                    roleTable.setTNumber(TableNumber);
                    roleTable.setTStatus(tableStatus);
                    
                roleList.add(roleTable);
                
                line = in.readLine();
            }
            in.close();
            return roleList;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
      
      
    public void addItem(RTable item) {
        String location = item.getLocation();
        String number=item.getTNumber();
        String status=item.getTStatus();
        int capacity=item.getCapacity();
        
        for (int i = 0; i < items.size(); i++) {
            RTable lineItem = items.get(i);
            if (lineItem.getTNumber().equals(number)) {
                lineItem.setCapacity(capacity);
                lineItem.setLocation(location);
                lineItem.setTStatus(status);
                lineItem.setTNumber(number);
                return;
            }
        }
        items.add(item);
    }

    public void updateItem(String TNumber,RTable item) {
        String location = item.getLocation();
        String number=item.getTNumber();
        String status=item.getTStatus();
        int capacity=item.getCapacity();
        
        for (int i = 0; i < items.size(); i++) {
            RTable lineItem = items.get(i);
            if (number.equals(TNumber)) {
                lineItem.setCapacity(capacity);
                lineItem.setLocation(location);
                lineItem.setTStatus(status);
                lineItem.setTNumber(number);
                items.add(lineItem);
                return;
            }
        }
       
    }

    
    
    public void removeItem(RTable item) {
        
        
        String code = item.getTNumber();
        for (int i = 0; i < items.size(); i++) {
            RTable lineItem = items.get(i);
            if (lineItem.getTNumber().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }

}
