package com.notfound.DAO;

public interface ReviewDAO {

	public void createReview(String rant);
	public void deleteReview();
	public void editReview(String rant);
	public void getReview(int userId);
}
