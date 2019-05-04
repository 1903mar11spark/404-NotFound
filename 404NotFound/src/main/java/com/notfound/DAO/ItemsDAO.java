package com.notfound.DAO;

import com.notfound.beans.Items;

public interface ItemsDAO {

	public Items getItemById(int id);
	public Items getItemByType(int itemType);
	public Items getItemByPrice(double price);
	public void setNewItem(String itemName, int itemType, String image, double price, boolean condition, int stock, float popularity);
	
}
