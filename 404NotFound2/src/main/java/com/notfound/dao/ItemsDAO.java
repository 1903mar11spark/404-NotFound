package com.notfound.dao;

import java.util.List;

import com.notfound.beans.Items;

public interface ItemsDAO {

	public List<Items> allItems();
	public Items getItemById(int id);
	public Items getItemByType(short itemType);
	public Items getItemByPrice(double price);
	public void setNewItem(Items item);
	
}
