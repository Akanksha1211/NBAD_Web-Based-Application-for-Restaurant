/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2data;

import com.assignment2.RTable;
import com.assignment2.User;
import java.util.ArrayList;

/**
 *
 * @author aavha
 */
public class UserData {
    
    public  ArrayList<User> user=null;
    public  ArrayList<RTable> rlist1=null;
    public static String code="1234";
            
    public UserData(){
        user =new ArrayList<User>();
        
        RTable r=new RTable("1","occupied",3,"aastrt");
        ArrayList<RTable> rlist=new ArrayList<RTable>();
        rlist.add(r);
        
        RTable r1=new RTable("1","occupied",3,"aastrt");
        rlist1=new ArrayList<RTable>();
        rlist.add(r1);
        
        User user1=new User("Akki","aavhad@uncc.edu","Akanksha","Avhad","1234","manager",rlist);
        User user2=new User("William","will@uncc.edu","William","S","1234","wait",rlist1);
        User user3=new User("Akki121","aavhad12@uncc.edu","Akanksha","Avhad","1234","host",rlist1);
        User user4=new User("Ak","aavhad12@uncc.edu","Akanksha","Avhad","1234","barattend",rlist1);
        User user5=new User("Akki1211","aavhad12@uncc.edu","Akanksha","Avhad","1234","busyboy",rlist1);
       
        
        user.add(user5);
        user.add(user4);
        user.add(user3);
        user.add(user2);
        user.add(user1);
        
    }
    
     public User getUser(String username) {
         
         User user_return=null;
        try {
             
            
            for(User user1:user){
                if(user1.getUserName().equals(username)){
                   user_return=user1;
                   System.out.print("FirstName"+user1.getFirstName());
                   return user_return;
                }   
            }
              
        }catch (Exception e) {
            System.err.println(e);
          return null;
        }
    
            return user_return;
     } 
     
      public User getUserRole(String username) {
         
         User user_return=null;
        try {
             
            
            for(User user1:user){
                if(user1.getUserName().equals(username)){
                   user_return=user1;
                   return user_return;
                }   
            }
              
        }catch (Exception e) {
            System.err.println(e);
          return null;
        }
    
            return user_return;
     }
      
      public  ArrayList<User> getUsers(){
          return user;
      }
}
