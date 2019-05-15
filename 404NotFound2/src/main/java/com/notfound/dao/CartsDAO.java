package com.notfound.dao;

import java.util.List;

import com.notfound.beans.Carts;

public interface CartsDAO {
	
	public void createNewCartItem (Carts cart);
	public void deleteCart(Carts cart);
	public void editCart(int userId, int itemId, int quantity);
	public List<Carts> getCartById(int userId);

}
