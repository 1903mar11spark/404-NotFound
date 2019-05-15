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
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "ITEMS")
	private List<Items> item;
	
	@Column(name = "TOTAL_PRICE")
	private double totalPrice;
	
	@Column(name = "ITEM_ID")
	private int itemId;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "PRICE")
	private int price;
	

	public Carts() {
		super();
	}
	
	public Carts(int userId) {
		this.userId = userId;
	}
	
	
	public Carts(int userId,double totalPrice, int itemId, int quantity, int price) {
		super();
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
	}

	public Carts(int cartId, int userId, List<Items> item, double totalPrice) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.item = item;
		this.totalPrice = totalPrice;
	}
	
	public Carts(int userId, double totalPrice) {
		super();
		this.userId = userId;
		this.totalPrice = totalPrice;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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
		return "Carts [cartId =" + cartId + ", userId=" + userId + ", item=" + item + ", totalPrice=" + totalPrice + "]";
	}
	
	
}