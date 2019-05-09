package com.notfound.DAO;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.notfound.beans.Login;
import com.notfound.util.ConnectionUtil;

@Repository(value="loginrDAO")
@Transactional
public class LoginDAOImpl implements LoginDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public void createLogin(Login login) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(login);
			tx.commit();
			s.close();
		}	
		
	}

	@Override
	public void editLogin(Login login) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(login);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public int getUserId(Login login) {
		int userId = 0;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "FROM LOGINS L WHERE L.USERNAME = " + login.getUserName()+ " AND WHERE L.PASSWORD = " + login.getPassword() + "";
			Query query = s.createQuery(hql);
			userId = query.getFirstResult();
			tx.commit();
		    s.close();
		}
		return userId;
	}

}
