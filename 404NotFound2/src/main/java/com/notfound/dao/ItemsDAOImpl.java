package com.notfound.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notfound.beans.Items;

@Repository(value = "itemsDAO")
@Transactional
public class ItemsDAOImpl implements ItemsDAO {

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public ItemsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Items getItemById(int id) {
		return sessionFactory.getCurrentSession().get(Items.class, id);
	}

	@Override
	public List<Items> getItemByType(int itemType) {
		List<Items> TItems = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		TItems = s.createQuery("from Items where itemType =" + itemType).getResultList();
	return TItems;
	}

	@Override
	public Items getItemByPrice(double price) {
		return sessionFactory.getCurrentSession().get(Items.class, price);
	}

	@Override
	public void setNewItem(Items item) {
		sessionFactory.getCurrentSession().persist(item);
		
	}

	@Override
	public List<Items> allItems() {
		List<Items> items = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		items = s.createQuery("from Items").getResultList();
	return items;
	}
}
