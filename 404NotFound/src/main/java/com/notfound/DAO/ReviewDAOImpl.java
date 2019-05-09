package com.notfound.DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.notfound.beans.Review;
import com.notfound.util.ConnectionUtil;

@Repository(value="reviewDAO")
@Transactional
public class ReviewDAOImpl implements ReviewDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public void createReview(String rant) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(rant);
			tx.commit();
			s.close();
		}		
	}

	@Override
	public void deleteReview(Review review) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(review);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public void editReview(String rant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Review getReview(int userId) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
