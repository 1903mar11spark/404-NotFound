package com.notfound.service;

import com.notfound.beans.Review;

public interface ReviewServices {

	public void createReview(String rant);
	public void deleteReview(Review review);
	public void editReview(String rant);
	public Review getReview(int userId);
}
