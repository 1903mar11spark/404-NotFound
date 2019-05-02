package com.notfound.beans;

public class ShaneBucks {
	
	private int id;
	private int amount;
	
	public ShaneBucks() {
		super();
	}
	
	public ShaneBucks(int id, int amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ShaneBucks [id=" + id + ", amount=" + amount + "]";
	}
	
	
}
