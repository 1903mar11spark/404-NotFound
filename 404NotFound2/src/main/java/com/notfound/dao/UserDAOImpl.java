package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "userDAO")
@Transactional
public class UserDAOImpl {

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
