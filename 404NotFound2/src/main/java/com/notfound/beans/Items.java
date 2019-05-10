package com.notfound.beans;

import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "itemSequence")
	@SequenceGenerator(allocationSize = 1, name = "itemSequence", sequenceName = "SQ_ITEM_PK")
	@Column(name = "ITEM_ID")
	private int itemId;
	
	@Column(name = "ITEM_NAME")
	private String itemName;
	
	@Column(name = "ITEM_TYPE")
	private int itemType;
	
	@Column(name = "IMAGE")
	private String image;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "CONDITION")
	private boolean condition;
	
	@Column(name = "STOCK")
	private int stock;
	
	@Column(name = "POPULARITY")
	private float popularity;
	
	
	public Items() {
		super();
	}
	
	public Items(int itemId) {
		this.itemId = itemId;
	}
	
	public Items(short itemType) {
		this.itemType = itemType;
	}
	
	public Items(double price) {
		this.price = price;
	}
	
	public Items(int itemId, String itemName, int itemType, String image, double price, boolean condition, int stock,
			float popularity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.image = image;
		this.price = price;
		this.condition = condition;
		this.stock = stock;
		this.popularity = popularity;
	}
	
	public Items(String itemName, int itemType, String image, double price, boolean condition, int stock,
			float popularity) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
		this.image = image;
		this.price = price;
		this.condition = condition;
		this.stock = stock;
		this.popularity = popularity;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isCondition() {
		return condition;
	}
	public void setCondition(boolean condition) {
		this.condition = condition;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getPopularity() {
		return popularity;
	}
	public void setPopularity(float popularity) {
		this.popularity = popularity;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + ", image=" + image
				+ ", price=" + price + ", condition=" + condition + ", stock=" + stock + ", popularity=" + popularity
				+ "]";
	}
		
	
}
