package com.islington.decor.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backend/SignOutServlet")
public class SignOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignOutServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate session
    	System.out.println("logout");
        HttpSession session = request.getSession(false); // false to avoid creating a new session
        System.out.println(request.getSession().getId());
        if (session != null) {
            session.invalidate();
        }

        // Redirect to login page (you can change the URL to wherever appropriate)
//        request.getRequestDispatcher("Login.jsp").forward(request, response);

        response.sendRedirect(request.getContextPath() + "/Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Handle POST same as GET
    }
}
