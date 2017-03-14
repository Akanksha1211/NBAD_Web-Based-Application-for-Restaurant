/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author aavha
 */
public class User implements Serializable{
    
    private String UserName;
    private String Email;
    private String FirstName;
    private String LastName;
    private String Password;
    private String Role;
    private List<RTable> RTable;

    public User(String UserName, String Email, String FirstName, String LastName, String Password, String Role, List<RTable> RTable) {
        this.UserName = UserName;
        this.Email = Email;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
        this.Role = Role;
        this.RTable = RTable;
    }
    
    public User() {
        }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPassword() {
        return Password;
    }
    
    

    public String getRole() {
        return Role;
    }

    public List<RTable> getRTable() {
        return RTable;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setRTable(List<RTable> RTable) {
        this.RTable = RTable;
    }
    
    
    
    
    
    
          
          
    
}

