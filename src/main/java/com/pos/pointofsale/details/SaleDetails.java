/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.details;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Alex
 */
public class SaleDetails implements java.io.Serializable {
    
    private Integer id;
    
    private LocalDate saleDate;
    
    private LocalTime saleTime;
    
    private String cashierName;
    
    private String storeName;
    
    private Double paymentAmount;

    public SaleDetails(Integer id, LocalDate saleDate, LocalTime saleTime, String cashierName, String storeName, Double paymentAmount) {
        this.id = id;
        this.saleDate = saleDate;
        this.saleTime = saleTime;
        this.cashierName = cashierName;
        this.storeName = storeName;
        this.paymentAmount = paymentAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public LocalTime getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(LocalTime saleTime) {
        this.saleTime = saleTime;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
