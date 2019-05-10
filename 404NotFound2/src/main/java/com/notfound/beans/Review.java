package com.notfound.beans;

import javax.persistence.*;

@Entity
@Table(name = "Review")
public class Review {
	
	@Id
	@Column(name = "REV_ID")
	private int revId;
	
	@Column(name = "RANT")
	private String rant;
	

	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "ITEM_ID")
	private int itemId;
	
	
	public Review() {
		super();
	}
	
	public Review(int revId, String rant, int userId ) {
		super();
		this.revId = revId;
		this.rant = rant;
		this.userId = userId;
		this.itemId = itemId;
	}
	
	public int getRevId() {
		return revId;
	}
	public void setRevId(int revId) {
		this.revId = revId;
	}
	public String getRant() {
		return rant;
	}
	public void setRant(String rant) {
		this.rant = rant;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Review [revId=" + revId + ", rant=" + rant + ", userId=" + userId + "]";
	}
		
	
}
