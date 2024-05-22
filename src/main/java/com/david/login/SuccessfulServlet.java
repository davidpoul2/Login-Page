package com.david.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/sucess")
public class SuccessfulServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try{
            Connection con = DataBaseConnection.getConnect();
            String query = "select * from userContact where userId = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,request.getParameter("username"));
            ResultSet rs = ps.executeQuery();
            rs.next();
            out.println("<html>");
            out.println("<head>");
            out.println("<link href = \"styles.css\" rel = \"stylesheet\">");
            out.println("</head>");
            out.println("<body class = bg-gray><div class = container >");
            out.println("<h1>---User Details---</h1><br>");
            out.println("<h4>UserId : " + rs.getString(1)+"<br>");
            out.println("Name : " + rs.getString(2)+"<br>");
            out.println("College : " + rs.getString(3)+"<br>");
            out.println("Degree : " + rs.getString(4)+"<br>");
            out.println("Branch : " + rs.getString(5)+"</h4><br>");
            out.println("Successful Login " +request.getParameter("username"));
            out.println("</div></body>");
            out.println("</html>");
        }
        catch(Exception e){
            out.println(e);
        }
    }
}
