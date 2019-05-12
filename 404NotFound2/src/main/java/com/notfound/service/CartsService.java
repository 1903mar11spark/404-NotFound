package com.notfound.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notfound.beans.Carts;
import com.notfound.dao.CartsDAO;

@Service
public class CartsService {

	private CartsDAO cartsDAO;
	@Autowired
	public CartsService(CartsDAO cartsDAO) {
		this.cartsDAO = cartsDAO;
	}
	
	public void createNewCartItem (Carts cart) {
		cartsDAO.createNewCartItem(cart);
	};
	public void deleteCart(Carts cart) {
		cartsDAO.deleteCart(cart);
	};
	public void editCart(Carts cart) {
		cartsDAO.editCart(cart);
	};
	public Carts getCartById(int userId) {
		return cartsDAO.getCartById(userId);
	};

}
