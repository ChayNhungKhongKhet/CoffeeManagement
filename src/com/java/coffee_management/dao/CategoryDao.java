/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.dao;

import com.java.coffee_management.model.Category;
import com.java.coffee_management.model.Table;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CategoryDao {
    public List<String> getAll(){
        List<String> categorys = new ArrayList<>();
        Connection con = new ConnectSQL().getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select [name] from category");
            while (rs.next()) {
                categorys.add(rs.getString("name"));
            }
            return categorys;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Category getById(int id) {
        Connection con = new ConnectSQL().getConnection();
        try {
            Category category = new Category();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from category "
                    + "where id = "+id);
            if (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
            return category;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
