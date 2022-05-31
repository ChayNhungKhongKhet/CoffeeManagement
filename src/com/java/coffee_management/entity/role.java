/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.entity;

/**
 *
 * @author ASUS
 */
public class role {
    int roleId;
    String nameRole;
    float amount_per_hour;

    public int getRoleId() {
        return roleId;
    }

    public String getNameRole() {
        return nameRole;
    }

    public float getAmount_per_hour() {
        return amount_per_hour;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public void setAmount_per_hour(float amount_per_hour) {
        this.amount_per_hour = amount_per_hour;
    }
    
}
