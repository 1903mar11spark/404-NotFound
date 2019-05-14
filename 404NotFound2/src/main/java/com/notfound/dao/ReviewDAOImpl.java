package com.notfound.dao;

import java.util.ArrayList;

import java.util.List;

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
	public void editReview(Review review) {
		sessionFactory.getCurrentSession().saveOrUpdate(review);	
		
	}

	@Override
	public List<Review> getReviewByItem(int itemId) {
		List<Review> reviews = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		reviews = s.createQuery("from Review where itemId =" + itemId).getResultList();
		return reviews;
	}
	
	public List<Review> getAllReviews() {
		List<Review> reviews = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		reviews = s.createQuery("from Review").getResultList();
	return reviews;
	}
}
