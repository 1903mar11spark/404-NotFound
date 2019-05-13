package com.notfound.dao;

import java.util.List;

import com.notfound.beans.Items;

public interface ItemsDAO {

	public List<Items> allItems();
	public Items getItemById(int id);
	public List<Items> getItemByType(int itemType);
	public List<Items> getItemByPrices(int price1, int price2);
	public void setNewItem(Items item);
	public List<Items> getItemByCondition(boolean condition);
}
