package com.notfound.dao;

import java.util.ArrayList;

import java.util.List;

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
	public void editCart(int userId, int itemId, int quantity) {
		Session s = sessionFactory.getCurrentSession();
		s.createQuery("update Carts set quantity =" + quantity + " where userId =" + userId+ " and itemId = "+ itemId).getResultList();
		
	}

	@Override
	public List<Carts> getCartById(int userId) {
		List<Carts> carts = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		carts = s.createQuery("from Carts where userId =" + userId).getResultList();
		return carts;
	}
}
