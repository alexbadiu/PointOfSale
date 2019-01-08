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
public class ProductSpecificationDetails implements java.io.Serializable {
    
    private Integer id;
    
    private String description;
    
    private Double price;
    
    private Integer unitOnStock;
    
    private String prodName;
    
    private Integer prodId;
    
    private String barcode;

    public ProductSpecificationDetails(Integer id, String description, Double price, Integer unitOnStock, String prodName, Integer prodId, String barcode) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.unitOnStock = unitOnStock;
        this.prodName = prodName;
        this.prodId = prodId;
        this.barcode = barcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUnitOnStock() {
        return unitOnStock;
    }

    public void setUnitOnStock(Integer unitOnStock) {
        this.unitOnStock = unitOnStock;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
