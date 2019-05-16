package com.notfound.beans;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "SHANE_BUCKS")
public class ShaneBucks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "shaneSequence")
	@SequenceGenerator(allocationSize = 1, name = "shaneSequence", sequenceName = "SQ_SHANE_PK")
	@Column(name = "SHANE_BUCKS_ID")
	private int id;
	
	@Column(name = "BALANCE")
	private float balance;
	

	@Column(name = "USER_ID")
	private int userId;
	
	public ShaneBucks() {
		super();
	}
	
	public ShaneBucks(int id, float balance, int userId) {
		super();
		this.id = id;
		this.balance = balance;
		this.userId = userId;
	}
	
	public ShaneBucks(float balance, int userId) {
		super();
		this.balance = balance;
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	} 
	@Override
	public String toString() {
		return "ShaneBucks [id=" + id + ", balance=" + balance + "userId=" + userId + "]";
	}
	
	
}
