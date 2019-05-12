package com.notfound.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notfound.beans.Review;
import com.notfound.dao.ReviewDAO;

@Service
public class ReviewService {

	private ReviewDAO reviewDAO;
	
	@Autowired
	public ReviewService(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}
	
	public void createReview(Review review) {
		reviewDAO.createReview(review);
	};
	public void deleteReview(Review review) {
		reviewDAO.deleteReview(review);
	};
	public void editReview(String rant) {
		reviewDAO.editReview(rant);
	};
	public Review getReview(int userId) {
		return reviewDAO.getReview(userId);
	};
	
}
