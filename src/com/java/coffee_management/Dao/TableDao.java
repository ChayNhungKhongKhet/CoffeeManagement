/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.Dao;

import com.java.coffee_management.model.Table;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TableDao {

    public List<Table> getAll() {
        List<Table> tables = new ArrayList<>();
        try {
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "select * from [table]";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Table table = new Table();
                table.setId(rs.getInt("id"));
                table.setArea(rs.getString("area"));
                table.setState(rs.getString("state"));
                tables.add(table);
            }
            return tables;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Table> getAllByArea(String area) {
        List<Table> tables = new ArrayList<>();
        try {
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "select * from [table]"
                    + " where area = N'"+area+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Table table = new Table();
                table.setId(rs.getInt("id"));
                table.setArea(rs.getString("area"));
                table.setState(rs.getString("state"));
                tables.add(table);
            }
            return tables;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<String> getAllArea() {
         List<String> areas = new ArrayList<>();
        try {
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "select distinct area from [table]";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                areas.add(rs.getString("area"));
            }
            return areas;
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
