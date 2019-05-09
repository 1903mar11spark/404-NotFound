package com.notfound.service;

import com.notfound.DAO.ReviewDAO;
import com.notfound.DAO.ReviewDAOImpl;
import com.notfound.beans.Review;

public class ReviewService implements ReviewServices {

	ReviewDAO rd = new ReviewDAOImpl();
	
	@Override
	public void createReview(String rant) {
		rd.createReview(rant);
	};
	@Override
	public void deleteReview(Review review) {
		rd.deleteReview(review);
	};
	@Override
	public void editReview(String rant) {
		rd.editReview(rant);
	};
	@Override
	public Review getReview(int userId) {
		return rd.getReview(userId);
	};
}
