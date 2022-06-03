/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.Dao;

import com.java.coffee_management.model.OrderDetail;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class OrderDetailDao {

    public int addOrder(int empId, int tableId) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date(System.currentTimeMillis());
            Statement st = ConnectSQL.getConnection().createStatement();
            String sql = "insert into [order](employee_id,table_id,date_time)values "
                    + "(" + empId + "," + tableId + ",'" + formatter.format(date)+"')";
            return st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int addOrderDetail(OrderDetail orderDetail) {
        try {
            int maxId = 0;
            Statement st = ConnectSQL.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select max(id) as 'id' from [order]");
            if(rs.next())
                maxId = rs.getInt("id");
            String sql = "insert into order_detail(order_id,product_id,size_id,quantity,price)values "
                    + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectSQL.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, maxId);
            preparedStatement.setInt(2, orderDetail.getProduct().getId());
            preparedStatement.setInt(3, orderDetail.getSize().getId());
            preparedStatement.setInt(4, orderDetail.getQuantity());
            preparedStatement.setDouble(5, orderDetail.getPrice());
            return preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
