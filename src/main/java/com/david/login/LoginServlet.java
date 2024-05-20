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

@WebServlet("/xyz")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        UserCredentials obj = new UserCredentials();
        String url = "jdbc:mysql://localhost:3306/login";
        obj.setUsername("root");
        obj.setPassword("1410");
        String query = "select * from UserDetails where username = ? and password = ?;";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, obj.getUsername(),obj.getPassword());
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

//      out.println("Gell");
            if(rs.next()){

                RequestDispatcher rd = request.getRequestDispatcher("sucess.html");
                rd.forward(request,response);
            }
            else{

                out.println("<h2 style = color:red>login unsuccessful :(<h2>");
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request,response);
            }
        }
        catch(Exception e){
            out.println(e);
        }
    }
}
