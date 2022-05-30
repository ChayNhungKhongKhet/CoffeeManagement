/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.Dao;


import com.java.coffee_management.entity.Employee_entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Dao {
   public List<Employee_entity> getAllEmployee_234(){
       List<Employee_entity> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from employee_role";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               Employee_entity tk = new Employee_entity();
               tk.setTennv(rs.getString("employee_id"));
               tk.setNgayVaoLam(rs.getString("role_id"));
               tk.setChucVu(rs.getString("start_job_date"));
               tk.setSoDienThoai(rs.getString("quit_job_date"));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
   
}
