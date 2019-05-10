package com.notfound.dao;

import com.notfound.beans.User;

public interface UserDAO {
	
	public void createUser(User user);
	public User updateUser(String firstName, String lastName, String address, String city, String country, int zip);
	
	
}
