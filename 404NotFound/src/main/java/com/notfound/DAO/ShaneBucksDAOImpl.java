package com.notfound.DAO;

import org.hibernate.SessionFactory;

import com.notfound.util.ConnectionUtil;

public class ShaneBucksDAOImpl implements ShaneBucksDAO{

	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public double getBalance(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBalance(int balance) {
		// TODO Auto-generated method stub
		
	}

}
