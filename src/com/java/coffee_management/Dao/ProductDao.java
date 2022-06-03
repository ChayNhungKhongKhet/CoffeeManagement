/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.Dao;

import com.java.coffee_management.model.Category;
import com.java.coffee_management.model.Product;
import com.java.coffee_management.model.Table;
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
public class ProductDao {
    private final CategoryDao cateDao = new CategoryDao();
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "select * from product";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(cateDao.getCategoryById(rs.getInt("category_id")));
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Product> getProductByCategoryId(Category category) {
        List<Product> products = new ArrayList<>();
        try {
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "select * from product "
                    + "where category_id = " + category.getId();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(category);
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Product getById(int id) {
        Product product = new Product();
         try {
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "select * from product "
                    + "where id = " + id;
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(cateDao.getCategoryById(rs.getInt("category_id")));
            }
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
