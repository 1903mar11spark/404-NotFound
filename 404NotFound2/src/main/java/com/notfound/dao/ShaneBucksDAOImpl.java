package com.notfound.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notfound.beans.Items;
import com.notfound.beans.Review;
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
	public float fetchBalance(int userId) {
		List<ShaneBucks> shaneing = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
	    shaneing = s.createQuery("from ShaneBucks where userId =" + userId).getResultList();
	    ShaneBucks shanes = shaneing.get(0);
	    return shanes.getBalance();
	}
	

	@Override
	public void setBalance(ShaneBucks shane) {
		sessionFactory.getCurrentSession().saveOrUpdate(shane);	
	}
}
