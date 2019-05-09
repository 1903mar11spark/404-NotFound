package com.notfound.service;


import org.springframework.stereotype.Service;

import com.notfound.DAO.CartsDAO;
import com.notfound.DAO.CartsDAOImpl;
import com.notfound.beans.Carts;
@Service
public class CartsService implements CartsServices {

	private CartsDAO cd = new CartsDAOImpl();
	
	@Override
	public void createNewCartItem (Carts cart) {
		cd.createNewCartItem(cart);
	};
	@Override
	public void deleteCart(Carts cart) {
		cd.deleteCart(cart);
	};
	@Override
	public void editCart(Carts cart) {
		cd.editCart(cart);
	};
	@Override
	public Carts getCartById(int userId) {
		return cd.getCartById(userId);
		
	};
}
