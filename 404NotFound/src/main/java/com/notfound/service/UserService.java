package com.notfound.service;

import com.notfound.DAO.UserDAO;
import com.notfound.DAO.UserDAOImpl;
import com.notfound.beans.User;

public class UserService implements UserServices{

	UserDAO ud = new UserDAOImpl();
	
	@Override
	public void createUser(User user) {
		ud.createUser(user);
	};
	@Override
	public User updateUser(String firstName, String lastName, String address, String city, String country, int zip) {
		return ud.updateUser(firstName, lastName, address, city, country, zip);
	};
}
