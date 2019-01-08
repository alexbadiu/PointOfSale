/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.pointofsale.details;

/**
 *
 * @author Alex
 */
public class ProductDetails implements java.io.Serializable {
    
    private Integer id;
    
    private String prodName;

    public ProductDetails(Integer id, String prodName) {
        this.id = id;
        this.prodName = prodName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
