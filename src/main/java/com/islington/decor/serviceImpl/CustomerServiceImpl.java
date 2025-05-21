package com.islington.decor.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.islington.decor.database.Database;
import com.islington.decor.model.Customer;
import com.islington.decor.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "insert into customer(first_name,last_name,username,password)values('"+customer.getFirstName()+"','"+customer.getLastName()+"','"+customer.getUsername()+"','"+customer.getPassword()+"')";
		try {
			Statement statement = Database.connectDatabase().createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer checkCustomer(String username, String password) {
	    Customer customer = null;
	    String sql = "SELECT * FROM customer WHERE username = ? AND password = ?";
	    
	    try (Connection conn = Database.connectDatabase();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, username);
	        stmt.setString(2, password);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            customer = new Customer();
	            customer.setCustomerId(rs.getInt("customer_id"));
	            customer.setFirstName(rs.getString("first_name"));
	            customer.setLastName(rs.getString("last_name"));
	            customer.setUsername(rs.getString("username"));
	            customer.setPassword(rs.getString("password"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return customer;
	}


//	 @Override
//	    public Customer getCustomerByUsername(String username) {
//	        Customer customer = null;
//	        try (Connection conn = DBUtil.getConnection()) {
//	            String sql = "SELECT * FROM customer WHERE username = ?";
//	            PreparedStatement stmt = conn.prepareStatement(sql);
//	            stmt.setString(1, username);
//	            ResultSet rs = stmt.executeQuery();
//
//	            if (rs.next()) {
//	                customer = new Customer();
//	                customer.setCustomerId(rs.getInt("customer_id"));
//	                customer.setFirstName(rs.getString("first_name"));
//	                customer.setLastName(rs.getString("last_name"));
//	                customer.setUsername(rs.getString("username"));
//	                customer.setPassword(rs.getString("password"));
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return customer;
//	    }
//	

}
