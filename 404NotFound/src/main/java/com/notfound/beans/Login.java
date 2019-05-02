package com.notfound.beans;

public class Login {

	private String userName;
	private String password;
	private boolean userType;
	private int userId;
	
	
	public Login() {
		super();
	}
	
	public Login(String userName, String password, boolean userType, int userId) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isUserType() {
		return userType;
	}
	public void setUserType(boolean userType) {
		this.userType = userType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + ", userType=" + userType + ", userId="
				+ userId + "]";
	}
	
	
}
