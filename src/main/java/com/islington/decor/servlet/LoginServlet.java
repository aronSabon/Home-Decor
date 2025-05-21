package com.islington.decor.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.islington.decor.model.Customer;
import com.islington.decor.service.CustomerService;
import com.islington.decor.serviceImpl.CustomerServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void destroy() {
        com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        super.destroy();
    }



    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to login page
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.checkCustomer(username, password); // You need to implement this method

        if (customer != null && customer.getPassword().equals(password)) {
            // Successful login
            request.getSession().setAttribute("customer", customer);
            response.sendRedirect("Dashboard.jsp"); // Replace with your post-login page
        } else {
            // Failed login
        	System.out.println("erosldkjf");
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
}
