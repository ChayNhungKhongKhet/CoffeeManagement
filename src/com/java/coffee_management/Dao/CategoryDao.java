/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.Dao;

import com.java.coffee_management.model.Category;
import com.java.coffee_management.model.Product;
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

    public List<Category> getAll() {
          List<Category> categories = new ArrayList<>();
        try {
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "select * from category";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
            return categories;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Category getCategoryById(int id) {
        Category category = new Category();
        try {
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "select * from category "
                    + "where id = " + id;
            ResultSet rs = st.executeQuery(sql);
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

    public Category getCategoryByName(String name) {
        Category category = new Category();
        try {
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "select * from category "
                    + "where [name] = N'" + name + "'";
            ResultSet rs = st.executeQuery(sql);
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
