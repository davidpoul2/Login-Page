package com.david.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String url = "jdbc:mysql://localhost:3306/login";
        String query = "select * from UserDetails where username = ? and password = ?;";
        try{
            Connection con = DataBaseConnection.getConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

//      out.println("Gell");
            if(rs.next()){

                RequestDispatcher rd = request.getRequestDispatcher("sucess");
                rd.forward(request,response);
            }
            else{

//                out.println("<h2 style = color:red;>login unsuccessful :(</h2>");
                RequestDispatcher rd = request.getRequestDispatcher("loginFail.html");
                rd.include(request,response);
            }
        }
        catch(Exception e){
            out.println(e);
        }
    }
}
