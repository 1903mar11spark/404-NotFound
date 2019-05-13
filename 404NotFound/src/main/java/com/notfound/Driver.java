package com.notfound;

import org.hibernate.SessionFactory;

import com.notfound.DAO.*;
import com.notfound.beans.*;
import com.notfound.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) {
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		
		ItemsDAO idi = new ItemsDAOImpl();
		Items item = new Items("XBox", 1, "derp.png", 300.00, false, 20, 8);
		idi.setNewItem(item);
	}
}
