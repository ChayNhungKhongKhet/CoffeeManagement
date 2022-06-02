/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.Dao;


import com.java.coffee_management.entity.Employee_entity;
import com.java.coffee_management.entity.Table;
import com.java.coffee_management.entity.employee_role;
import com.java.coffee_management.entity.role;
import com.java.coffee_management.entity.Menu_entity;
import com.java.coffee_management.entity.category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Dao {
   public List<Employee_entity> getAllEmployee_234(){
       List<Employee_entity> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select employee.[name],start_job_date,employee.phone, [role].[name],employee.[user_name],employee.[password], employee.id  from  employee , employee_role, [role]  where employee.id = employee_role.employee_id and employee_role.role_id = [role].id";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               Employee_entity tk = new Employee_entity();
               tk.setTennv(rs.getString(1));
               tk.setNgayVaoLam(rs.getString("start_job_date"));
               tk.setSoDienThoai(rs.getString("phone"));
               tk.setChucVu(rs.getString(4));
               tk.setUserName(rs.getString("user_name"));
               tk.setPassword(rs.getString("password"));
               tk.setId(rs.getInt(7));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
   public List<Employee_entity> searchEmployee_234(String name){
       List<Employee_entity> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select employee.[name],start_job_date,employee.phone, [role].[name],employee.[user_name],employee.[password], employee.id  from  employee , employee_role, [role]  where employee.id = employee_role.employee_id and employee_role.role_id = [role].id and employee.[name] like N'%"+name+"%'";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               Employee_entity tk = new Employee_entity();
               tk.setTennv(rs.getString(1));
               tk.setNgayVaoLam(rs.getString("start_job_date"));
               tk.setSoDienThoai(rs.getString("phone"));
               tk.setChucVu(rs.getString(4));
               tk.setUserName(rs.getString("user_name"));
               tk.setPassword(rs.getString("password"));
               tk.setId(rs.getInt(7));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
   public List<Employee_entity> searchCVEmployee_234(String name){
       List<Employee_entity> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select employee.[name],start_job_date,employee.phone, [role].[name],employee.[user_name],employee.[password], employee.id  from  employee , employee_role, [role]  where employee.id = employee_role.employee_id and employee_role.role_id = [role].id and [role].[name] like N'%"+name+"%'";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               Employee_entity tk = new Employee_entity();
               tk.setTennv(rs.getString(1));
               tk.setNgayVaoLam(rs.getString("start_job_date"));
               tk.setSoDienThoai(rs.getString("phone"));
               tk.setChucVu(rs.getString(4));
               tk.setUserName(rs.getString("user_name"));
               tk.setPassword(rs.getString("password"));
               tk.setId(rs.getInt(7));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
    public List<Table> getAllTable_234(){
       List<Table> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from [table]";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               Table tk = new Table();
               tk.setId(rs.getInt("id"));
               tk.setTang(rs.getString("area"));
               tk.setBan(rs.getString("state"));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
    public List<Table> getAllTable_234(int tt){
       List<Table> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from [table] where area like '%"+tt+"%'";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               Table tk = new Table();
               tk.setId(rs.getInt("id"));
               tk.setTang(rs.getString("area"));
               tk.setBan(rs.getString("state"));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
    public List<Table> getAllTableById_234(int  tt){
       List<Table> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from [table] where name like '%"+tt+"%'";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               Table tk = new Table();
               tk.setId(rs.getInt("id"));
               tk.setTang(rs.getString("area"));
               tk.setBan(rs.getString("state"));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
   public List<role> getAllRole_234(){
       List<role> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from role";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               role r= new role();
               r.setRoleId(rs.getInt("id"));
               r.setNameRole(rs.getString("name"));
               empl.add(r);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
   public int getIdEmployeeMax(){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from employee";
       int i=0;
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while (rs.next()){
               i=rs.getInt("id");
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return i;
   }
   public int getRoleByName(String name){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select id from role where name = '"+name+"'";
       int i = 0;
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while (rs.next()){
               i=rs.getInt("id");
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return i;
   }
   public void addEmployee_234(Employee_entity e1,employee_role e2,String name){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "insert into employee([name],[user_name],[phone],[password]) values(N'"+e1.getTennv()+"','"+e1.getUserName()+"','"+e1.getSoDienThoai()+"','"+e1.getPassword()+"')";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           System.out.println();
           System.out.println(sql);
           int rs = pr.executeUpdate();
       }catch(Exception ex){
           ex.printStackTrace();
       }
       int i= getIdEmployeeMax();
        System.out.println("id max"+i);
       int i1= getRoleByName(name);
        System.out.println("idrole"+i1);
       sql = "insert into employee_role(employee_id,role_id,start_job_date) values("+i+","+i1+",'"+e2.getStart()+"')";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
            System.out.println();
           System.out.println(sql);
           int  rs = pr.executeUpdate();
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
   public void UpdateEmployee_234(String id,String ht,String sdt){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "update employee set name = N'"+ht+"',phone = '"+sdt+"' where id= "+id;
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           int rs = pr.executeUpdate();
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
   public int demNV(){
     Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from employee";
       int i=0;
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           
           while(rs.next()){
               i=rs.getRow();
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }  
       return i;
   }
   public void addTable(int i){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "insert into [Table](area,state) values(N'Tầng "+i+"',N'trống')";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           int rs = pr.executeUpdate();
       }catch(Exception ex){
           ex.printStackTrace();
       }  
   }
   public void updateTable(int id,int tang){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "update [Table] set area = N'Tầng "+tang+"' where id = "+id;
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           int rs = pr.executeUpdate();
       }catch(Exception ex){
           ex.printStackTrace();
       }  
   }
   public int demBan(){
     Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from [Table]";
       int i=0;
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           
           while(rs.next()){
               i=rs.getRow();
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }  
       return i;
   }
   public int demMenu(){
     Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from [product]";
       int i=0;
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           
           while(rs.next()){
               i=rs.getRow();
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }  
       return i;
   }
    public void deleteTable(int i){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "delete [table] where id ="+i;
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           int rs = pr.executeUpdate();
       }catch(Exception ex){
           ex.printStackTrace();
       }  
   }
   public List<Menu_entity> getAllMenu_234(){
       List<Menu_entity> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select product.id,category_id,category.name,product.name,price from product,category where product.category_id=category.id";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               Menu_entity tk = new Menu_entity();
               tk.setIdP(rs.getInt(1));
               tk.setIdC(rs.getInt(2));
               tk.setNameC(rs.getString(3));
               tk.setNameP(rs.getString(4));
               tk.setPrice(rs.getFloat(5));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
   public List<Menu_entity> getAllMenu1_234(String name){
       List<Menu_entity> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select product.id,category_id,category.[name],product.[name],price from product,category where product.category_id=category.id and category.[name] = N'"+name+"'";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               Menu_entity tk = new Menu_entity();
               tk.setIdP(rs.getInt(1));
               tk.setIdC(rs.getInt(2));
               tk.setNameC(rs.getString(3));
               tk.setNameP(rs.getString(4));
               tk.setPrice(rs.getFloat(5));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
   public List<Menu_entity> getAllMenu_234(String name){
       List<Menu_entity> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select product.id,category_id,category.[name],product.[name],price from product,category where product.category_id=category.id and product.[name] like N'%"+name+"%'";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               Menu_entity tk = new Menu_entity();
               tk.setIdP(rs.getInt(1));
               tk.setIdC(rs.getInt(2));
               tk.setNameC(rs.getString(3));
               tk.setNameP(rs.getString(4));
               tk.setPrice(rs.getFloat(5));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
   public List<category> getAllCategory_234(){
       List<category> empl = new ArrayList<>();
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from category";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while(rs.next()){
               category tk = new category();
               tk.setId(rs.getInt(1));
               tk.setName(rs.getString(2));
               empl.add(tk);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return empl;
   }
   public int getIdCategoryByName(String name){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from category where [name] = N'"+name+"'" ;
       int i = 0;
       System.out.println(name+" ");
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while (rs.next()){
               i=rs.getInt("id");
               
           }
       }catch(Exception ex){
           ex.printStackTrace();
       };
       return i;
   }
   public void addMenu(String nameC,String name,float gia){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "insert into product(category_id,[name],price) values(?,?,?)";
       int idC= getIdCategoryByName(nameC);
       System.out.println("\n"+idC);
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           pr.setInt(1,idC);
           pr.setString(2,name);
           pr.setFloat(3,gia);
           int rs = pr.executeUpdate();
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
   public void updateMenu(int idP,String nameC,String name,float gia){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "update product set category_id= ?,name = ?, price = ? where id= ?";
       int idC= getIdCategoryByName(nameC);
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           pr.setInt(4,idP);
           pr.setInt(1,idC);
           pr.setString(2,name);
           pr.setFloat(3,gia);
           int rs = pr.executeUpdate();
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
   public void deleteMenu(int id){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "delete product where id = "+id;
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           int rs = pr.executeUpdate();
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
   public int login_234(String userName, String pass){
       Connection connect = ConnectionDB.Connect_JDBC();
       String sql = "select * from employee where [user_name]= '"+userName+"' and [password]= '"+pass+"'";
       try{
           PreparedStatement pr = connect.prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           while (rs.next()){
               return 1;
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return 0;
   }
}
