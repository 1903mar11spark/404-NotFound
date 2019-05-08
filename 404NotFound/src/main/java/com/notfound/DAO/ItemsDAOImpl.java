package com.notfound.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.notfound.beans.Items;
import com.notfound.util.ConnectionUtil;

public class ItemsDAOImpl implements ItemsDAO {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public Items getItemById(int id) {
		Items i = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			i = (Items) s.get(Items.class, id);
			tx.commit();
		    s.close();
		}
		return i;
	}

	@Override
	public Items getItemByType(short itemType) {
		Items i = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			i = (Items) s.get(Items.class, itemType);
			tx.commit();
		    s.close();
		}
		return i;
	}

	@Override
	public Items getItemByPrice(double price) {
		Items i = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			i = (Items) s.get(Items.class, price);
			tx.commit();
		    s.close();
		}
		return i;
	}

	@Override
	public void setNewItem(Items item) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(item);
			tx.commit();
			s.close();
		}	
		
	}

}
