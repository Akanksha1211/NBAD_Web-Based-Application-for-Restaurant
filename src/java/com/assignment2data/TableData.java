/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2data;

import com.assignment2.RTable;
import java.util.ArrayList;

/**
 *
 * @author aavha
 */
public class TableData {
    
    
    ArrayList<RTable> roleList=new ArrayList<RTable>();
    
    TableData(){
        
        RTable rtable1=new RTable("1","Occupied",4,"east");
        RTable rtable2=new RTable("2","Free",4,"east");
        RTable rtable3=new RTable("3","Occupied",4,"east");
        roleList.add(rtable3);
        roleList.add(rtable2);
        roleList.add(rtable1);
        
    }
    
    public  RTable getTableInfo(String tableNumber){
        
        RTable rtable=null;
        
        for(RTable r:roleList){
            if(r.getTNumber().equals(tableNumber)){
                rtable=r;
                return r;
            }
        }
        return rtable;
        
    }
    
    public ArrayList<RTable> getTable(){
        return roleList;           
    }
    
    public void addItem(RTable item) {
        roleList.add(item);
    }

    public void updateItem(String TNumber,RTable item) {  
        
        for(RTable role:roleList){
            if(TNumber.equals(role.getTNumber())){
                roleList.remove(role);
                roleList.add(item);
            }
            
        }
        
    }
}
