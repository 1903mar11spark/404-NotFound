package com.notfound.dao;

import com.notfound.beans.ShaneBucks;

public interface ShaneBucksDAO {

	public void makeNewBalance(ShaneBucks shane);
	public double getBalance(int userId);
	public void setBalance(int balance, int userId);
	
}
