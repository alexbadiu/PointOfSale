/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "SALES")
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer id;
    
    private LocalDate saleDate;
    
    private LocalTime saleTime;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_KEY")
    private User cashier;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_KEY")
    private Store store;
    
    private Double paymentAmount;

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

    public User getCashier() {
        return cashier;
    }

    public void setCashier(User cashier) {
        this.cashier = cashier;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.pointofsale.entity.Sale[ id=" + id + " ]";
    }
    
}
