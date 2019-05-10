package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "loginDAO")
@Transactional
public class LoginDAOImpl {

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
