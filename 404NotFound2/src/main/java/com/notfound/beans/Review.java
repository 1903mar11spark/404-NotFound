package com.notfound.beans;

import javax.persistence.*;

@Entity
@Table(name = "Review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reviewSequence")
	@SequenceGenerator(allocationSize = 1, name = "reviewSequence", sequenceName = "SQ_REVIEW_PK")
	@Column(name = "REV_ID")
	private int revId;
	
	@Column(name = "RANT")
	private String rant;
	

	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "ITEM_ID")
	private int itemId;
	
	@Column(name = "REVIEW_SCORE")
	private int reviewScore;
	
	
	public Review() {
		super();
	}
	
	public Review(int revId, String rant, int userId,int itemId, int reviewScore) {
		super();
		this.revId = revId;
		this.rant = rant;
		this.userId = userId;
		this.itemId = itemId;
		this.reviewScore = reviewScore;
	}
	public Review(String rant, int userId,int itemId, int reviewScore) {
		super();
		this.rant = rant;
		this.userId = userId;
		this.itemId = itemId;
		this.reviewScore = reviewScore;
	}
	
	public int getRevId() {
		return revId;
	}
	public void setRevId(int revId) {
		this.revId = revId;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
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
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "Review [revId=" + revId + ", rant=" + rant + ", userId=" + userId + ", itemId=" + itemId + "]";
	}
		
	
}
