/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.Service;

import com.java.coffee_management.Dao.Dao;
import com.java.coffee_management.model.Employee_entity;
import com.java.coffee_management.model.Menu_entity;
import com.java.coffee_management.model.Table;
import com.java.coffee_management.model.category;
import com.java.coffee_management.model.employee_role;
import com.java.coffee_management.model.role;
import java.util.List;

/**
 *
 * @author ASUS
 */

public class Service {
    Dao dao = new Dao();
    public List<Employee_entity> getAllEmployee_234(){
        return dao.getAllEmployee_234();
    }
    public List<Table> getAllTable_234(){
        return dao.getAllTable_234();
    }
    public List<Table> getAllTable_234(int tt){
        return dao.getAllTable_234(tt);
    }
    public List<Table> getAllTableById_234(int tt){
        return dao.getAllTableById_234(tt);
    }
    public List<role> getAllRole_234(){
        return dao.getAllRole_234();
    }
    public List<category> getAllCategory_234(){
        return dao.getAllCategory_234();
    }
    public List<Menu_entity> getAllMenu_234(){
        return dao.getAllMenu_234();
    }
    public List<Menu_entity> getAllMenu_234(String name){
        return dao.getAllMenu_234(name);
    }
    public List<Menu_entity> getAllMenu1_234(String name){
        return dao.getAllMenu1_234(name);
    }
    public List<Employee_entity> searchEmployee_234(String name){
        return dao.searchEmployee_234(name);
    }
    public List<Employee_entity> searchCVEmployee_234(String name){
        return dao.searchCVEmployee_234(name);
    }
    public void addEmployee_234(Employee_entity e1,employee_role e2,String name){
        dao.addEmployee_234(e1, e2, name);    
    }
    public void updateEmployee_234(String id,String ht, String sdt){
        dao.UpdateEmployee_234(id, ht, sdt);
    }
    public int demNV(){
        return dao.demNV();
    }
    public int demBan(){
        return dao.demBan();
    }
    public int demMenu(){
        return dao.demMenu();
    }
    public void addTable(int i){
        dao.addTable(i);
    }
    public void updateTable(int i,int tang){
        dao.updateTable(i,tang);
    }
    public void deleteTable(int i){
        dao.deleteTable(i);
    }
    public void addMenu(String nameC,String name,float price){
        dao.addMenu(nameC,name,price);
    }
    public void updateMenu(int i,String nameC,String name,float price){
        dao.updateMenu(i,nameC,name,price);
    }
    public void deleteMenu(int i){
        dao.deleteMenu(i);
    }
    public int login_234(String userName, String pass){
        return dao.login_234(userName,pass);
    }
}
