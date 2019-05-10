package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		double balance = 0;
		Session s = sessionFactory.getCurrentSession();
		balance = s.createQuery("FROM SHANE_BUCKS WHERE USER_ID =" + userId + "").getFirstResult();
		return balance;	
	}

	@Override
	public void setBalance(int balance, int userId) {
		Session s = sessionFactory.getCurrentSession();
		s.createQuery("UPDATE SHANE_BUCKS SET BALANCE= " + balance+ " WHERE USER_ID =" + userId + "").getFirstResult();		
	}
	
}
