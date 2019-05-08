package com.notfound.DAO;

import com.notfound.beans.Login;

public interface LoginDAO {

	public void createLogin(Login login);
	public void editLogin(Login login);
	public int getUserId(Login login);
}
