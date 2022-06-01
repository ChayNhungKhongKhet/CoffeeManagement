/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.dao;

import com.java.coffee_management.model.Product;
import com.java.coffee_management.model.Size;
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
public class ProductDao {

    CategoryDao cateDao = new CategoryDao();

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        Connection con = new ConnectSQL().getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setCategory(cateDao.getById(rs.getInt("category_id")));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Product getById(int id) {
        Connection con = new ConnectSQL().getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product "
                    + "where id =" + id);
            Product product = new Product();
            if (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setCategory(cateDao.getById(rs.getInt("category_id")));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
            }
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Product getByName(String name) {
        Connection con = new ConnectSQL().getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product "
                    + "where name ='" + name + "'");
            Product product = new Product();
            if (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setCategory(cateDao.getById(rs.getInt("category_id")));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
            }
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Size getSizeByName(String name) {
        Connection con = new ConnectSQL().getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from size "
                    + "where name = '"+name+"'");
            Size size = new Size();
            if (rs.next()) {
                size.setId(rs.getInt("id"));
                size.setName(rs.getString("name"));
                size.setMorePrice(rs.getDouble("extra_price"));
            }
            return size;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
