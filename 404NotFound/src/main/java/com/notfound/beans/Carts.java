package com.notfound.beans;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CARTS")
public class Carts {
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private int userId;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "ITEMS")
	private List<Items> item;
	
	@Column(name = "TOTAL_PRICE")
	private double totalPrice;
	
	
	public Carts() {
		super();
	}
	
	public Carts(int userId, List<Items> item, double totalPrice) {
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
	public List<Items> getItem() {
		return item;
	}
	public void setItem(List<Items> item) {
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
