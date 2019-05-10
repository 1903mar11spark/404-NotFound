package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notfound.beans.Review;

@Repository(value = "reviewDAO")
@Transactional
public class ReviewDAOImpl implements ReviewDAO{

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public ReviewDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void createReview(Review review) {
		sessionFactory.getCurrentSession().persist(review);	
	}

	@Override
	public void deleteReview(Review review) {
		sessionFactory.getCurrentSession().delete(review);		
	}

	@Override
	public void editReview(String rant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Review getReview(int userId) {
		return sessionFactory.getCurrentSession().get(Review.class, userId);
	}
}
