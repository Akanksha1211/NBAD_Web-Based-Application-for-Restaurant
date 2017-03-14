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
public class TableAmount implements Serializable{
    
    private String TNumber;
    private Double amount;

    public TableAmount(String TNumber, Double amount) {
        this.TNumber = TNumber;
        this.amount = amount;
    }
    
     public TableAmount() {
       }

    public String getTNumber() {
        return TNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setTNumber(String TNumber) {
        this.TNumber = TNumber;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
}

