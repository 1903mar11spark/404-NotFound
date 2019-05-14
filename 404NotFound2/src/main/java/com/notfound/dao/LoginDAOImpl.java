package com.notfound.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notfound.beans.Login;
import com.notfound.beans.User;

@Repository(value = "loginDAO")
@Transactional
public class LoginDAOImpl implements LoginDAO {

	private Login login;
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
	public int gettingUserId(String userName, String password) {
		
		Login gotUserId = sessionFactory.getCurrentSession().get(Login.class, userName);
		if (gotUserId.getPassword().contains(password)) {
			int usersId = gotUserId.getUserId();
			return usersId;
		} else {
			return -1;
		}
	}

	@Override
	public List<Login> getAllLogin() {
		List<Login> logins = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		logins = s.createQuery("from Login").getResultList();
	return logins;
	}
}
