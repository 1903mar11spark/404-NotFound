package com.notfound.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.notfound.beans.Carts;
import com.notfound.util.ConnectionUtil;

public class CartsDAOImpl implements CartsDAO{

	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public void createNewCartItem(Carts cart) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(cart);
			tx.commit();
			s.close();
		}	
	}

	@Override
	public void deleteCart(Carts cart) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(cart);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public void editCart(Carts cart) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(cart);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public Carts getCartById(int userId) {
		Carts c = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			c = (Carts) s.get(Carts.class, userId);
			tx.commit();
		    s.close();
		}
		return c;
		
	}

}
