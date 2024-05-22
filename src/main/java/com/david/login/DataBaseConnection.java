package com.david.login;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    public static Connection con = null;
    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","1410");
        } catch (Exception e) {

        }
    }

    public static Connection getConnect(){
        return con;
    }
}
