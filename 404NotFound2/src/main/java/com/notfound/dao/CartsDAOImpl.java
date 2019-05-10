package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "cartsDAO")
@Transactional
public class CartsDAOImpl {
	
	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public CartsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
