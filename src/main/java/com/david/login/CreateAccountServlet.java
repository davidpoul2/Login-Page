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

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/login";
            Connection con = DriverManager.getConnection(url,"root","1410");
            String query = "insert into userContact value(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,req.getParameter("userId"));
            ps.setString(2,req.getParameter("name"));
            ps.setString(3,req.getParameter("college"));
            ps.setString(4,req.getParameter("degree"));
            ps.setString(5,req.getParameter("stream"));
            ps.executeUpdate();

            String query2 = "insert into UserDetails values(?,?)";
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setString(1,req.getParameter("userId"));
            ps2.setString(2,req.getParameter("password"));
            ps2.executeUpdate();
        }
        catch(Exception e){}
        RequestDispatcher rs = req.getRequestDispatcher("login.html");
        rs.include(req,res);
    }
}
