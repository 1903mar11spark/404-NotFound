package com.notfound.DAO;

import com.notfound.beans.User;

public interface UserDAO {
	
	public void createUser();
	public User updateUser(String firstName, String lastName, String address, String city, String country, int zip);
	
			
	
	
}
