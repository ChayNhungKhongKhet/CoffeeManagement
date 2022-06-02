/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.coffee_management.Dao;

import java.sql.*;
import java.util.*;

public class ConnectSQL {
    public static Connection Connect_JDBC(){
        final String Url = "jdbc:sqlserver://DESKTOP-MU64O7N\\SQLEXPRESS:1433;database=coffee_management";
        final String user = "sa";
        final String pass = "123456";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(Url, user, pass);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

