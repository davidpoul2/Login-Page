<<<<<<< HEAD
//package com.david.login;
//
//import com.mysql.cj.jdbc.Driver;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.PrintWriter;
//import java.sql.*;
//
//@WebServlet("/success")
//public class UserCredentials extends HttpServlet {
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response){
//
//        String url = "jdbc:mysql://localhost:3306/login";
//        String user = "root";
//        String password = "1410";
//        Connection con = null;
//        String query = "select * from userContact where userID = ?";
//        try{
//            Class.forName("com.mysql.cj.jdbc");
//            con = DriverManager.getConnection(url,user,password);
//            PreparedStatement st = con.prepareStatement(query);
//            st.setString(1,request.getParameter("username"));
//            ResultSet rs = st.executeQuery();
//
//            rs.next();
//
//            PrintWriter out = response.getWriter();
//            out.println("<h1>---User Details---<h1>");
//            out.println("userId = " +rs.getString(1));
//            out.println("Name = "  + rs.getString(2));
//            out.println("College = " + rs.getString(3));
//            out.println("Degree = " + rs.getString(4));
//            out.println("Branch = " + rs.getString(5));
//        }
//        catch (Exception e){}
//    }
//
//}
=======
package com.david.login;

import com.mysql.cj.jdbc.Driver;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/sucess")
public class UserCredentials extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){

        String url = "jdbc:mysql://localhost:3306/login";
        String user = "root";
        String password = "1410";
        Connection con = null;
        String query = "select * from userContact where userID = ?";
        try{
            Class.forName("com.mysql.cj.jdbc");
            con = DriverManager.getConnection(url,user,password);
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,request.getParameter("username"));
            ResultSet rs = st.executeQuery();

            rs.next();

            PrintWriter out = response.getWriter();
            out.println("<h1>---User Details---<h1>");
            out.println("userId = " +rs.getString(1));
            out.println("Name = "  + rs.getString(2));
            out.println("College = " + rs.getString(3));
            out.println("Degree = " + rs.getString(4));
            out.println("Branch = " + rs.getString(5));
        }
        catch (Exception e){}
    }

}
>>>>>>> b02c54568f7bd9912038697fb69dcd3945b7fc37
