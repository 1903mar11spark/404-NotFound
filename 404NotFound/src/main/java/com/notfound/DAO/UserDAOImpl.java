package com.notfound.DAO;

import org.hibernate.SessionFactory;

import com.notfound.beans.User;
import com.notfound.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(String firstName, String lastName, String address, String city, String country, int zip) {
		// TODO Auto-generated method stub
		return null;
	}

}
