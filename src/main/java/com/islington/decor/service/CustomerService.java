package com.islington.decor.service;

import java.util.List;

import com.islington.decor.model.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);
	List<Customer> getAllCustomer();
	void deleteCustomerById(int id);
	Customer getCustomerById(int id);
//	Customer getCustomerByUsername(String username);
	void updateCustomer(Customer customer);
	Customer checkCustomer(String username,String password);
}
