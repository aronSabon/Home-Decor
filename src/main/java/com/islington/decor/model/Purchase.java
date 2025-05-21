package com.islington.decor.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Purchase {

	private int purchaseId;
	    private Customer customer;
		private Product product;
	    private int quantity;
	    private LocalDate purchaseDate;
	    private LocalTime purchaseTime;
	    private int price;
	    private boolean paid;
	    
		public boolean isPaid() {
			return paid;
		}
		public void setPaid(boolean paid) {
			this.paid = paid;
		}
		public int getPurchaseId() {
			return purchaseId;
		}
		public void setPurchaseId(int purchaseId) {
			this.purchaseId = purchaseId;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public LocalDate getPurchaseDate() {
			return purchaseDate;
		}
		public void setPurchaseDate(LocalDate purchaseDate) {
			this.purchaseDate = purchaseDate;
		}
		public LocalTime getPurchaseTime() {
			return purchaseTime;
		}
		public void setPurchaseTime(LocalTime purchaseTime) {
			this.purchaseTime = purchaseTime;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
	    public Customer getUser() {
			return customer;
		}
		public void setUser(Customer customer) {
			this.customer = customer;
		}
		@Override
		public String toString() {
			return "Purchase [purchaseId=" + purchaseId + ", customer=" + customer + ", product=" + product + ", quantity="
					+ quantity + ", purchaseDate=" + purchaseDate + ", purchaseTime=" + purchaseTime + ", price="
					+ price + ", paid=" + paid + "]";
		}
	    
	
}
