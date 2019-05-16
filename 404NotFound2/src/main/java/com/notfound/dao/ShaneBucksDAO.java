package com.notfound.dao;

import com.notfound.beans.ShaneBucks;

public interface ShaneBucksDAO {

	public void makeNewBalance(ShaneBucks shane);
	public float fetchBalance(int userId);
	public void setBalance(ShaneBucks shane);
	
}
