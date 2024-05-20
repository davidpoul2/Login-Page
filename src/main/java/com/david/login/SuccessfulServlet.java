package com.david.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/success")
public class SuccessfulServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html style = background-color:#143A52;text-align: center;color:white>");
        out.println("<h1>login Successful :)<h1>");
        out.println("</html>");
        response.getWriter().println("Successful Login " +request.getParameter("username"));
    }
}
