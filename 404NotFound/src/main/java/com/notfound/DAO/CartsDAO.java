package com.notfound.DAO;

import java.util.List;

import com.notfound.beans.Items;

public interface CartsDAO {
	
	public void createNewCartItem (int userId, List<Items> item, double totalPrice);
	public void deleteCartById(int userId);
	public void editCartByIf(int userId);
	public void getCartById(int userId);

}
