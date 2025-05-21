package com.islington.decor.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	        List<Product> productList = new ArrayList<>();

	        try (Connection conn = Database.connectDatabase()) {
	            String sql = "SELECT product_id, name, price, image_name FROM product";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Product product = new Product();
	                product.setProductId(rs.getInt("product_id"));
	                product.setName(rs.getString("name"));
	                product.setPrice(rs.getInt("price"));
	                product.setImageName(rs.getString("image_name"));

	                productList.add(product);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return productList;
	    }

	@Override
	public void deleteProductById(int id) {
	    String sql = "DELETE FROM product WHERE product_id = ?";
	    try (Connection conn = Database.connectDatabase();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        int rows = ps.executeUpdate();
	        System.out.println("Rows deleted: " + rows);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Product product) {
	    try {
	        Connection conn = Database.connectDatabase();
	        System.out.println("Database connected: " + (conn != null));
	        Statement statement = conn.createStatement();

	        // Use UPDATE query to update existing product by productId
	        String sql = "UPDATE product SET "
	                   + "name = '" + product.getName() + "', "
	                   + "price = " + product.getPrice() + ", "
	                   + "image_name = '" + product.getImageName() + "' "
	                   + "WHERE product_id = '" + product.getProductId() + "'";

	        System.out.println("SQL: " + sql);
	        int rows = statement.executeUpdate(sql);
	        System.out.println("Rows affected: " + rows);

	        statement.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// In ProductServiceImpl.java
	@Override
	public List<Product> getLatestThreeProducts() {
	    List<Product> products = new ArrayList<>();
	    try (Connection conn = Database.connectDatabase()) {
	        String sql = "SELECT * FROM product ORDER BY product_id DESC LIMIT 3";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Product product = new Product();
	            product.setProductId(rs.getInt("product_id"));
	            product.setName(rs.getString("name"));
	            product.setPrice(rs.getInt("price"));
	            product.setImageName(rs.getString("image_name"));
	            products.add(product);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return products;
	}



}
