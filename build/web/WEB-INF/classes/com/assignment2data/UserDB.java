/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2data;

import com.assignment2.Password;
import com.assignment2.RTable;
import com.assignment2.Role;
import com.assignment2.User;
import com.assignment2.UserTable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author aavha
 */
public class UserDB {
    
    public static Password getPassword(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Password password=null;
        String query = "SELECT * FROM userpassword "
                + "WHERE UserName = ?"; 
        try {
             ps = connection.prepareStatement(query);
             ps.setString(1, username);
             rs = ps.executeQuery();
             password=new Password();
             if(rs.next()){
                 password.setUserName(rs.getString("UserName"));
                 password.setPassword(rs.getString("UserPassword"));
                 password.setSalt(rs.getString("Salt"));
                 
             }
            return password;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
   
    public static int insertUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO users (UserName, UserPassword, Email, FirstName, LastName) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
    
            
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int insertUSerPassword(String username, String passwordhash, String salt) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO userpassword (UserName, UserPassword, Salt) "
                + "VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, passwordhash);
            ps.setString(3, salt);
           
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static boolean validateUser(String password, String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

         String query = "SELECT UserName, UserPassword FROM users "
                + "WHERE UserName = ?"; 
       
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = null;
            Boolean value=false;
            rs = ps.executeQuery();
            User user=user= new User();
            while (rs.next()) {
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("UserPassword"));    
            }
            if((user.getUserName()).equals(username) && (user.getPassword()).equals(password)){
                value=true;
            }
            else{
                value=false;
            }
            
            
            return value;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int insertRole(String role) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO roles (RoleName) "
                + "VALUES (?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, role);
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int insertUserRole(String username,String role) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO userrole (UserName,RoleName) "
                + "VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, role);
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    
    public static ArrayList<User> selectUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> userList=new ArrayList<User>();

        String query = "SELECT * FROM users";
        
        try {
            ps = connection.prepareStatement(query);
             rs = ps.executeQuery();
              User user=null;
            while (rs.next()) {
               user= new User();
                user.setUserName(rs.getString("UserName"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                userList.add(user);
            }
            
            return userList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static User selectUserRole(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> userList=new ArrayList<User>();

        String query = "SELECT * FROM userrole "
                + "WHERE UserName = ?"; 
        try {
             ps = connection.prepareStatement(query);
             ps.setString(1, username);
             rs = ps.executeQuery();
             User user=new User();
             if(rs.next()){
                 user.setUserName(rs.getString("UserName"));
                 user.setRole(rs.getString("RoleName"));
                 
             }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
   
   
        public static ArrayList<Role> getRoles() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Role> roleList=new ArrayList<Role>();

        String query = "SELECT * FROM roles";
        
        try {
            ps = connection.prepareStatement(query);
             rs = ps.executeQuery();
              Role role=null;
            while (rs.next()) {
               role= new Role();
                role.setRole(rs.getString("RoleName"));
                roleList.add(role);
            }
            
            return roleList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
     public static User getUser(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String query = "SELECT * FROM users "
                + "WHERE UserName = ?"; 
        try {
            ps = connection.prepareStatement(query);
             ps.setString(1, username);
             rs = ps.executeQuery();
              User user= new User();
            while (rs.next()) {
               
                user.setUserName(rs.getString("UserName"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("UserPassword"));
                
            }
            
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    
    }
     
    public static int updateRole(String username,String role) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE userrole SET "
                + "RoleName = ? "
                + "WHERE UserName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, role);
            ps.setString(2, username);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
 
     
     
     
       public static ArrayList<UserTable> getUserTable(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<UserTable> userTableList=new ArrayList<UserTable>();
       
        String query = "SELECT * FROM usertable "
                + "WHERE UserName = ?"; 
        try {
            ps = connection.prepareStatement(query);
             ps.setString(1, username);
             rs = ps.executeQuery();
              UserTable usertable=null;
              
            while (rs.next()) {
              usertable= new UserTable();
                usertable.setUserName(rs.getString("UserName"));
                usertable.setTNumber(rs.getString("TableNumber"));
                userTableList.add(usertable);
            }
            
            return userTableList;
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    
    }
     
     
     public static String getUserRole(String username) {
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String role=null;
        String query = "SELECT RoleName FROM userrole "
                + "WHERE UserName = ?"; 
        try {
            ps = connection.prepareStatement(query);
             ps.setString(1, username);
             rs = ps.executeQuery();
             if(rs.next()){
                role= (rs.getString("RoleName"));
             }
            return role;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    
    }
     
     public static ArrayList<String> getUsernameRole(String role) {
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> list=new ArrayList<String>();
        String username=null;
        String query = "SELECT UserName FROM userrole "
                + "WHERE RoleName = ?"; 
        try {
            ps = connection.prepareStatement(query);
             ps.setString(1, role);
             rs = ps.executeQuery();
             while(rs.next()){
                username= (rs.getString("UserName"));
                list.add(username);
             }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    
    }
     
    public static ArrayList<User> getUsers(String filepath) {
        ArrayList<User> userList = new ArrayList<User>();
        ArrayList<RTable> roleList=new ArrayList<RTable>();
        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String username= t.nextToken();
                String email=t.nextToken();
                String firstname=t.nextToken();
                    String lastname=t.nextToken();
                    String password=t.nextToken();
                    String role=t.nextToken();
                
                User user= new User();
                    user.setUserName(username);
                    user.setEmail(email);
                    user.setFirstName(firstname);
                    user.setLastName(lastname);
                    user.setPassword(password);
                    user.setPassword(password);
                    user.setRole(role);
                    
                    
                RTable r=new RTable();
                RTable r1=new RTable();
                
                r.setLocation("east");
                r.setCapacity(4);
                r.setTNumber("1");
                r.setTStatus("occupied");
                
                r1.setLocation("east");
                r1.setCapacity(4);
                r1.setTNumber("2");
                r1.setTStatus("free");
                
                roleList.add(r);
                roleList.add(r1);
                  
                user.setRTable(roleList);
                userList.add(user);
                
                
                line = in.readLine();
            }
            in.close();
            return userList;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
     
     
}

