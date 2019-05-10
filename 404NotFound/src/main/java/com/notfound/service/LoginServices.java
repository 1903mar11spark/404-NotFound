package com.notfound.service;

import com.notfound.beans.Login;

public interface LoginServices {

	public void createLogin(Login login);
	public void editLogin(Login login);
	public int getUserId(Login login);
}
