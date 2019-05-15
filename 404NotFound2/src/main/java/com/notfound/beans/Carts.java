package com.notfound.beans;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CARTS")
public class Carts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cartSequence")
	@SequenceGenerator(allocationSize = 1, name = "cartSequence", sequenceName = "SQ_CART_PK")
	@Column(name = "CART_ID")
	private int cartId;
	

	@Column(name = "USER_ID")
	private int userId;
	
	
	@Column(name = "ITEM_ID")
	private int itemId;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "PRICE")
	private double price;
	

	public Carts() {
		super();
	}
	
	public Carts(int userId) {
		this.userId = userId;
	}
	
	
	public Carts(int userId, int itemId, int quantity, double price) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
	}

	public Carts(int cartId, int userId) {
		super();
		this.cartId = cartId;
		this.userId = userId;
	}
	
	
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Carts [cartId =" + cartId + ", userId=" + userId + "]";
	}
	
	
}