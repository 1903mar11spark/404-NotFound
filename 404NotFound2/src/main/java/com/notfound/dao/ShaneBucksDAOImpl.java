package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notfound.beans.Items;
import com.notfound.beans.ShaneBucks;

@Repository(value = "shaneBucksDAO")
@Transactional
public class ShaneBucksDAOImpl implements ShaneBucksDAO {

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public ShaneBucksDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void makeNewBalance(ShaneBucks shane) {
		sessionFactory.getCurrentSession().persist(shane);
		
	}

	@Override
	public double getBalance(int userId) {
		return sessionFactory.getCurrentSession().get(ShaneBucks.class, userId).getAmount();
	}

	@Override
	public void setBalance(int balance, int userId) {
		Session s = sessionFactory.getCurrentSession();
		s.createQuery("update ShanekBucks set Balance= " + balance+ " where userId =" + userId + "").getFirstResult();		
	}
	
}
