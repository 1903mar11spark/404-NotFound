package com.notfound.beans;

public class Review {
	
	private int revId;
	private String rant;
	private int userId;
	
	
	public Review() {
		super();
	}
	
	public Review(int revId, String rant, int userId) {
		super();
		this.revId = revId;
		this.rant = rant;
		this.userId = userId;
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
