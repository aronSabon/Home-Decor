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

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//    @Override
//    public void destroy() {
//        com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
//        super.destroy();
//    }

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setUsername(username);
		customer.setPassword(password);
		
		CustomerService customerService = new CustomerServiceImpl();
		customerService.addCustomer(customer);
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
