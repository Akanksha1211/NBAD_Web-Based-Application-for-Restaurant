/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2;

import java.io.Serializable;

/**
 *
 * @author aavha
 */
public class RTable implements Serializable{
    
    
    private String TNumber;
    private String TStatus;
    private int capacity;
    private String Location;

    public RTable(){
        
    }

    public RTable(String TNumber, String TStatus, int capacity, String Location) {
        this.TNumber = TNumber;
        this.TStatus = TStatus;
        this.capacity = capacity;
        this.Location = Location;
    }
    
    public String getTNumber() {
        return TNumber;
    }

    public String getTStatus() {
        return TStatus;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return Location;
    }

    public void setTNumber(String TNumber) {
        this.TNumber = TNumber;
    }

    public void setTStatus(String TStatus) {
        this.TStatus = TStatus;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
    
    
}
