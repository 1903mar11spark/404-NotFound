package com.notfound.dao;

import com.notfound.beans.Review;

public interface ReviewDAO {

	public void createReview(String rant);
	public void deleteReview(Review review);
	public void editReview(String rant);
	public Review getReview(int userId);
}
