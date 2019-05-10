package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "reviewDAO")
@Transactional
public class ReviewDAOImpl {

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public ReviewDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
