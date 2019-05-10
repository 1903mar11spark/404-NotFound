package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "itemsDAO")
@Transactional
public class ItemsDAOImpl {

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public ItemsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
