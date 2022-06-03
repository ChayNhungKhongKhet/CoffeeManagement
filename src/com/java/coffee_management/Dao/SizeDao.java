/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.Dao;

import com.java.coffee_management.model.Product;
import com.java.coffee_management.model.Size;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SizeDao {

    public Size getByName(String name) {
        Size size = new Size();
        try {
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "select * from size "
                    + "where [name] = '" + name+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
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
