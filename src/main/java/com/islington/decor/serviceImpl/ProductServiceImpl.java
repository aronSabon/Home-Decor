package com.islington.decor.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.islington.decor.database.Database;
import com.islington.decor.model.Product;
import com.islington.decor.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product product) {
	    System.out.println("addProduct method called");
	    try {
	        Connection conn = Database.connectDatabase();
	        System.out.println("Database connected: " + (conn != null));
	        Statement statement = conn.createStatement();
	        String sql = "INSERT INTO product(name, price, image_name) VALUES ('"
	                     + product.getName() + "', " + product.getPrice() + ", '" + product.getImageName() + "')";
	        System.out.println("SQL: " + sql);
	        int rows = statement.executeUpdate(sql);
	        System.out.println("Rows affected: " + rows);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

}
