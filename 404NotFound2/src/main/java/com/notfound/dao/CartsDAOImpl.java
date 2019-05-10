package com.notfound.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notfound.beans.Carts;

@Repository(value = "cartsDAO")
@Transactional
public class CartsDAOImpl implements CartsDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public CartsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createNewCartItem(Carts cart) {
		sessionFactory.getCurrentSession().persist(cart);
	}

	@Override
	public void deleteCart(Carts cart) {
		sessionFactory.getCurrentSession().delete(cart);
		
	}

	@Override
	public void editCart(Carts cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
	}

	@Override
	public Carts getCartById(int userId) {
		return sessionFactory.getCurrentSession().get(Carts.class, userId);
	}
}
