package com.notfound.DAO;

import com.notfound.beans.Items;

public interface ItemsDAO {

	public Items getItemById(int id);
	public Items getItemByType(short itemType);
	public Items getItemByPrice(double price);
	public void setNewItem(Items item);
	
}
