package com.notfound.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.notfound.beans.Login;
import com.notfound.util.ConnectionUtil;

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
		// TODO Auto-generated method stub
		return 0;
	}

}
