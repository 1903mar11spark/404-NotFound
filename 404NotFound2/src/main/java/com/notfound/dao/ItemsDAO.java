package com.notfound.dao;

import java.util.List;

import com.notfound.beans.Items;

public interface ItemsDAO {

	public List<Items> allItems();
	public Items getItemById(int id);
	public List<Items> getItemByType(int itemType);
	public Items getItemByPrice(double price);
	public void setNewItem(Items item);
	
}
