package com.islington.decor.serviceImpl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.islington.decor.database.Database;
import com.islington.decor.model.Product;
import com.islington.decor.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		String sql = "insert into product(name,price,imageName)values('"+product.getName()+"','"+product.getPrice()+"','"+product.getImageName()+"')";
		try {
			Statement statement = Database.connectDatabase().createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
