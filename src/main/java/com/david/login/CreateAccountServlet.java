package com.david.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/create")
public class CreateAccountServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("Hell0 kkdkkdd");
        System.out.println(req.getParameter("userid"));
        try{
            Connection con = DataBaseConnection.getConnect();
            String query = "insert into userContact value(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,req.getParameter("userid"));
            ps.setString(2,(req.getParameter("firstname")+req.getParameter("lastname")));
            ps.setString(3,req.getParameter("college"));
            ps.setString(4,req.getParameter("degree"));
            ps.setString(5,req.getParameter("branch"));
            int val = ps.executeUpdate();
            System.out.println(val);

            String query2 = "insert into UserDetails values(?,?)";
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setString(1,req.getParameter("userid"));
            ps2.setString(2,req.getParameter("password"));
            ps2.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
        RequestDispatcher rs = req.getRequestDispatcher("login.html");
        rs.include(req,res);
        System.out.println("Successfull account created");
    }
}
