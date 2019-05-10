package com.notfound.service;

import org.springframework.stereotype.Service;

import com.notfound.DAO.LoginDAO;
import com.notfound.DAO.LoginDAOImpl;
import com.notfound.beans.Login;

@Service
public class LoginService implements LoginServices{
	
	private LoginDAO ld = new LoginDAOImpl();
	
	@Override
	public void createLogin(Login login) {
		ld.createLogin(login);
	};
	@Override
	public void editLogin(Login login) {
		ld.editLogin(login);
	};
	@Override
	public int getUserId(Login login) {
		return ld.getUserId(login);
		
	};
}
