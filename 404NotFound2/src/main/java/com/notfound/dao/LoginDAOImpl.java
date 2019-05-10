package com.notfound.dao;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notfound.beans.Login;

@Repository(value = "loginDAO")
@Transactional
public class LoginDAOImpl implements LoginDAO {

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void createLogin(Login login) {
		sessionFactory.getCurrentSession().persist(login);	
	}

	@Override
	public void editLogin(Login login) {
		sessionFactory.getCurrentSession().saveOrUpdate(login);	
	}

	@Override
	public int getUserId(Login login) {
		int userId = 0;
		Session s = sessionFactory.getCurrentSession();
			userId = s.createQuery("FROM LOGINS L WHERE L.USERNAME = " + login.getUserName()+ " AND WHERE L.PASSWORD = " + login.getPassword() + "").getFirstResult();

		return userId;
	}
}
