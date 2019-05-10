package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "shaneBucksDAO")
@Transactional
public class ShaneBucksDAOImpl {

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public ShaneBucksDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
