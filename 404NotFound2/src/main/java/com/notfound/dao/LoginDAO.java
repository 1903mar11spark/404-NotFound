package com.notfound.dao;

import java.util.List;

import com.notfound.beans.Login;

public interface LoginDAO {

	
	public void createLogin(Login login);
	public void editLogin(Login login);
	public int gettingUserId(String userName, String password);
	public List<Login> getAllLogin();
}
