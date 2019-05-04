package com.notfound;

import org.hibernate.SessionFactory;

import com.notfound.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) {
		SessionFactory sf = ConnectionUtil.getSessionFactory();
	}
}
