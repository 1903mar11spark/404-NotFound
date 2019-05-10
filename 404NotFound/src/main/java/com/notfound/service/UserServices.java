package com.notfound.service;

import com.notfound.beans.User;

public interface UserServices {
	
	public void createUser(User user);
	public User updateUser(String firstName, String lastName, String address, String city, String country, int zip);
}
