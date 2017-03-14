/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2;

/**
 *
 * @author aavha
 */
public class UserTable {
    
    private String UserName;
    private String TNumber;

    public UserTable(String UserName, String TNumber) {
        this.UserName = UserName;
        this.TNumber = TNumber;
    }

    public UserTable() {
      }
    
    public String getUserName() {
        return UserName;
    }

    public String getTNumber() {
        return TNumber;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setTNumber(String TNumber) {
        this.TNumber = TNumber;
    }

    
            
  

}
