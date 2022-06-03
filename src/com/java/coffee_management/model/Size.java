/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.model;

/**
 *
 * @author Admin
 */
public class Size {
    private Integer id;
    private String name;
    private Double morePrice;

    public Size(Integer id, String name, Double morePrice) {
        this.id = id;
        this.name = name;
        this.morePrice = morePrice;
    }

    public Size() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMorePrice() {
        return morePrice;
    }

    public void setMorePrice(Double morePrice) {
        this.morePrice = morePrice;
    }
    
}
