package com.notfound.beans;

import javax.persistence.*;

@Entity
@Table(name = "SHANE_BUCKS")
public class ShaneBucks {
	
	@Column(name = "SHANE_BUCKS_ID")
	private int id;
	
	@Column(name = "BALANCE")
	private int balance;
	
	public ShaneBucks() {
		super();
	}
	
	public ShaneBucks(int id, int balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return balance;
	}
	public void setAmount(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "ShaneBucks [id=" + id + ", balance=" + balance + "]";
	}
	
	
}
