package com.notfound.dao;

import com.notfound.beans.User;

public interface UserDAO {
	
	public void createUser(User user);
	public void updateUser(User user);
	public User getUserById(int id);
	
	
}
