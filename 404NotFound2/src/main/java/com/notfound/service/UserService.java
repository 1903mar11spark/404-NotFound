package com.notfound.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notfound.beans.User;
import com.notfound.dao.UserDAO;

@Service
public class UserService {

	private UserDAO userDAO;
	@Autowired
	public UserService (UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void createUser(User user) {
		userDAO.createUser(user);
	};
	public void updateUser(User user) {
		userDAO.updateUser(user);
	};
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	};
}
