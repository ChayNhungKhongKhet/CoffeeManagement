/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.model;

/**
 *
 * @author ASUS
 */
public class Menu_entity {
    int idP,idC;
    String nameP,nameC;
    float price;

    public int getIdP() {
        return idP;
    }

    public int getIdC() {
        return idC;
    }

    public String getNameP() {
        return nameP;
    }

    public String getNameC() {
        return nameC;
    }

    public float getPrice() {
        return price;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
