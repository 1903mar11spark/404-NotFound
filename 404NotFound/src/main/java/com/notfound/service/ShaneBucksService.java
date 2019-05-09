package com.notfound.service;

import com.notfound.DAO.ShaneBucksDAO;
import com.notfound.DAO.ShaneBucksDAOImpl;

public class ShaneBucksService implements ShaneBucksServices {

	ShaneBucksDAO sbd = new ShaneBucksDAOImpl();
	
	@Override
	public double getBalance(int id) {
		return sbd.getBalance(id);
	};
	@Override
	public void setBalance(int balance) {
		sbd.setBalance(balance);
		
	};
}
