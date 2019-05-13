package com.notfound.DAO;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.notfound.util.ConnectionUtil;

@Repository(value= "shaneBucksDAO")
@Transactional
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
