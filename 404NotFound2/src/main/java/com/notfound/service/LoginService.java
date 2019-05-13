package com.notfound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notfound.beans.Items;
import com.notfound.beans.Login;
import com.notfound.dao.LoginDAO;

@Service
public class LoginService {

	private LoginDAO loginDAO;
	
	@Autowired
	public LoginService(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	public void createLogin(Login login) {
		loginDAO.createLogin(login);
	};
	public void editLogin(Login login) {
		loginDAO.editLogin(login);
	};
	public int getUserId(Login login) {
		return loginDAO.getUserId(login);
	};
	public List<Login> allLogins() {
		return loginDAO.getAllLogin();
	}
}
