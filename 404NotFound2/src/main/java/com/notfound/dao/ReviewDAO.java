package com.notfound.dao;

import java.util.List;

import com.notfound.beans.Review;

public interface ReviewDAO {

	public void createReview(Review review);
	public void deleteReview(Review review);
	public void editReview(Review review);
	public List<Review> getReviewByItem(int itemId);
	public List<Review> getAllReviews();
}
