package com.notfound.beans;

public class Carts {
	
	private int userId;
	private Items item;
	private double totalPrice;
	
	
	public Carts() {
		super();
	}
	
	public Carts(int userId, Items item, double totalPrice) {
		super();
		this.userId = userId;
		this.item = item;
		this.totalPrice = totalPrice;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Items getItem() {
		return item;
	}
	public void setItem(Items item) {
		this.item = item;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Carts [userId=" + userId + ", item=" + item + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
