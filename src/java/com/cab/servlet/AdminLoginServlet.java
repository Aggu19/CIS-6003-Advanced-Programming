package com.cab.servlet;

import com.cab.dao.CustomerDAO;
import com.cab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Assuming hardcoded admin credentials for simplicity
        if (username.equals("admin") && password.equals("admin123")) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", "admin");
            response.sendRedirect("admin/home.jsp");  // Redirect to the admin home page
        } else {
            request.setAttribute("errorMessage", "Invalid admin credentials");
            request.getRequestDispatcher("admin/login.jsp").forward(request, response);
        }
    }
}
