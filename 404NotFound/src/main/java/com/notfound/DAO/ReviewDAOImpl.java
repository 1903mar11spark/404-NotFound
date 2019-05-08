package com.notfound.DAO;

import org.hibernate.SessionFactory;

import com.notfound.util.ConnectionUtil;

public class ReviewDAOImpl implements ReviewDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public void createReview(String rant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReview() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editReview(String rant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReview(int userId) {
		// TODO Auto-generated method stub
		
	}

}
