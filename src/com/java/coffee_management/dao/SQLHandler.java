/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.dao;

import java.sql.ResultSet;

/**
 *
 * @author asus
 */
public class SQLHandler {
      public ConnectSQL conn = new ConnectSQL();

    public SQLHandler() {
        conn.connect();
    }

    public ResultSet getAllDataTKHoaDon338() {
        String query = "select id,date_time, table_id, quantity * price from [order], order_detail where [order].id = order_detail.order_id" ;
        return conn.getData(query);
    }    

    public ResultSet getAllDataTKKho338() {
        String query = "select receipt_id,supplier_id,[name],[date] ,ingredient_id,quanlity,price, quanlity * price  from supplier,receipt , receipt_detail where supplier.id = receipt.supplier_id and receipt.id = receipt_detail.receipt_id" ;
        return conn.getData(query);
    }
    
    public ResultSet getAllDataTKKhoDesc338() {
        String query = "select receipt_id,supplier_id,[name],[date] ,ingredient_id,quanlity,price, quanlity * price as ThanhTien from supplier,receipt , receipt_detail where supplier.id = receipt.supplier_id and receipt.id = receipt_detail.receipt_id order by ThanhTien desc" ;
        return conn.getData(query);
    }
    
     public ResultSet getAllDataTKKhoAsc338() {
        String query = "select receipt_id,supplier_id,[name],[date] ,ingredient_id,quanlity,price, quanlity * price as ThanhTien from supplier,receipt , receipt_detail where supplier.id = receipt.supplier_id and receipt.id = receipt_detail.receipt_id order by ThanhTien asc" ;
        return conn.getData(query);
    }
     
    public ResultSet getCountTKHDB338(){
        String query = "select COUNT (*)from [order]" ;
        return conn.getData(query);
    }
    
    public ResultSet getCountTKHDN338(){
        String query = "select COUNT (*)from receipt" ;
        return conn.getData(query);
    }
    
    public ResultSet getCountTKNV338(){
        String query = "select COUNT (*)from employee" ;
        return conn.getData(query);
    }
}
