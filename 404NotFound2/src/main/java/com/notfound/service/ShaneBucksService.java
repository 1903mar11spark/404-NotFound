package com.notfound.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notfound.beans.ShaneBucks;
import com.notfound.dao.ShaneBucksDAO;

@Service
public class ShaneBucksService {

	private ShaneBucksDAO shaneBucksDAO;
	@Autowired
	public ShaneBucksService (ShaneBucksDAO shaneBucksDAO) {
		this.shaneBucksDAO = shaneBucksDAO;
	}
	
	public void makeNewBalance(ShaneBucks shane) {
		shaneBucksDAO.makeNewBalance(shane);
	};
	public float fetchBalance(int userId) {
		return shaneBucksDAO.fetchBalance(userId);
	};
	public void setBalance(ShaneBucks shane) {
		shaneBucksDAO.setBalance(shane);
	};
}
