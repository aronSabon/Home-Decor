package com.islington.decor.model;

import java.util.List;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String password;
	private String username;
	private String role;
//	private List<Purchase> purchases;
	
	public int getCustomerId() {
		return customerId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", username=" + username + ", role=" + role + "]";
	}
	
	
	
	
	
	
	
	
	
}
