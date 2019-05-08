package com.notfound.DAO;

import com.notfound.beans.Carts;

public interface CartsDAO {
	
	public void createNewCartItem (Carts cart);
	public void deleteCart(Carts cart);
	public void editCart(Carts cart);
	public Carts getCartById(int userId);

}
