package com.islington.decor.model;

public class Product {
	private int productId;
	private String name;
	private int price;
	private String imageName;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", imageName=" + imageName
				+ "]";
	}
	
	
}
