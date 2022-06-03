/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.model;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class OrderDetail {
    private Product product;
    private Size size;
    private int quantity;
    private Double price;

    public OrderDetail(Product product, Size size, int quantity) {
        this.product = product;
        this.size = size;
        this.quantity = quantity;
        
    }

    public OrderDetail() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return product.getPrice() + size.getMorePrice();
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    
}
