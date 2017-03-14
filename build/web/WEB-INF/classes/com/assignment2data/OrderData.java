/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2data;

import com.assignment2.Menu;
import com.assignment2.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aavha
 */
public class OrderData {
    
    List<Order> orderList=null;
  
    ArrayList<Menu> menuList =null;
    
    public OrderData(){
        
        menuList = new ArrayList<Menu>();
        
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
        Menu menu12= new Menu(12,"Man","Alcoholic",2.5);
        
        
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
        

    orderList= new ArrayList<Order>();
    
             
//     Order order1 =new Order("1","Akki",1,"12:00", "12:00", "12:00", 1,1, 2.2,2.2,menuList);
//     Order order2 =new Order("2","Akki",2,"12:00", "12:00", "12:00", 21,2, 2.232,2.232, menuList);
    // Order order3 =new Order("3","Akki",2,"12:00", "12:00", "12:00", 21,2, 2.232,2.232, menuList);
     
    // orderList.add(order1);
    // orderList.add(order2);
     //orderList.add(order3);
     
    }
       
    public Order getOrder(String orderId){
        Order order=null;
        
        for(Order order1:orderList){
            String id =order1.getOrderId();
            if(id==orderId){
                order=order1;
                return order;
            }
        }
        return order;
    }
    
    public List<Order> getUserOrders(String username){
        List<Order> orderL =new ArrayList<Order>();
         
        for(Order order1:orderList){
            String usernamenew=order1.getUsername();
            if(usernamenew.equals(username)){
                orderL.add(order1);
            }   
        }
        return orderL;
    }
    public List<Order> getOrders(){
        return orderList;
    }
    
    public ArrayList<Menu> getMenuList(){
        return menuList;
    }
}

