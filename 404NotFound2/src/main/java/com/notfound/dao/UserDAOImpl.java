package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notfound.beans.User;

@Repository(value = "userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
		
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public User getUserById(int id) {
		return sessionFactory.getCurrentSession().get(User.class, id);	}
}
