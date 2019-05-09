package com.notfound.service;

import com.notfound.DAO.ItemsDAO;
import com.notfound.DAO.ItemsDAOImpl;
import com.notfound.beans.Items;

public class ItemsService implements ItemServices {
	
	private ItemsDAO idi = new ItemsDAOImpl();
	
	@Override
	public Items getItemById(int id) {
		return idi.getItemById(id);
	};
	@Override
	public Items getItemByType(short itemType) {
		return idi.getItemByType(itemType);
	};
	@Override
	public Items getItemByPrice(double price) {
		return idi.getItemByPrice(price);
	};
	@Override
	public void setNewItem(Items item) {
		idi.setNewItem(item);
	};

}
