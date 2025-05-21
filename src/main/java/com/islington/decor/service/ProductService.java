package com.islington.decor.service;

import java.util.List;

import com.islington.decor.model.Product;

public interface ProductService {

	void addProduct(Product product);
	List<Product> getAllProduct();
	void deleteProductById(int id);
	Product getProductById(int id);
	void updateProduct(Product product);
	List<Product> getLatestThreeProducts();
}
