/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.Dao;

import java.sql.*;

/**
 *
 * @author asus
 */
public class SQLHandler {
    private ConnectSQL conn;
    public SQLHandler() {
        conn = new ConnectSQL();
    }

    public ResultSet getAllDataTKHoaDon338() {
        String query = "select id,date_time, table_id, quantity * price from [order], order_detail where [order].id = order_detail.order_id" ;
        return conn.getData338(query);
    }
    
    public ResultSet getAllDataTKHoaDonDate338(String datefrom, String dateto) {
        String query = "select id,date_time, table_id, quantity * price from [order], order_detail where [order].id = order_detail.order_id and DATEDIFF(day, '"+datefrom+"',date_time) >=0 and DATEDIFF(day, date_time, '"+dateto+"') >=0" ;
        return conn.getData338(query);
    }
    
    public ResultSet getAllDataTKKho338() {
        String query = "select receipt_id,supplier_id,[name],[date] ,ingredient_id,quanlity,price, quanlity * price  from supplier,receipt , receipt_detail where supplier.id = receipt.supplier_id and receipt.id = receipt_detail.receipt_id" ;
        return conn.getData338(query);
    }
    
    public ResultSet getAllDataTKKhoDesc338() {
        String query = "select receipt_id,supplier_id,[name],[date] ,ingredient_id,quanlity,price, quanlity * price as ThanhTien from supplier,receipt , receipt_detail where supplier.id = receipt.supplier_id and receipt.id = receipt_detail.receipt_id order by ThanhTien desc" ;
        return conn.getData338(query);
    }
    
     public ResultSet getAllDataTKKhoAsc338() {
        String query = "select receipt_id,supplier_id,[name],[date] ,ingredient_id,quanlity,price, quanlity * price as ThanhTien from supplier,receipt , receipt_detail where supplier.id = receipt.supplier_id and receipt.id = receipt_detail.receipt_id order by ThanhTien asc" ;
        return conn.getData338(query);
    }
     
    public ResultSet getCountTKHDB338(){
        String query = "select COUNT (*)from [order]" ;
        return conn.getData338(query);
    }
    
    public ResultSet getCountTKHDN338(){
        String query = "select COUNT (*)from receipt" ;
        return conn.getData338(query);
    }
    
    public ResultSet getCountTKNV338(){
        String query = "select COUNT (*)from employee" ;
        return conn.getData338(query);
    }
    
    
    public ResultSet getDataDate338(String datefrom, String dateto) {
        String query = "select receipt_id,supplier_id,[name],[date] ,ingredient_id,quanlity,price, quanlity * price  from supplier,receipt , receipt_detail where supplier.id = receipt.supplier_id and receipt.id = receipt_detail.receipt_id and DATEDIFF(day, '"+datefrom+"',[date]) >=0 and DATEDIFF(day, [date], '"+dateto+"') >=0";
        return conn.getData338(query);
    }
}
