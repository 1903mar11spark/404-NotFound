package com.notfound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.notfound.dao.ItemsDAO;
import com.notfound.beans.Items;
@Service
public class ItemService {
	
	private ItemsDAO itemDAO;
	@Autowired
	public ItemService(ItemsDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	public Items getItemById(int id) {
		return itemDAO.getItemById(id);
	};
	public Items getItemByType(short itemType) {
		return itemDAO.getItemByType(itemType);
	};
	public Items getItemByPrice(double price) {
		return itemDAO.getItemByPrice(price);
	};
	public void setNewItem(Items item) {
		itemDAO.setNewItem(item);
	};
	public List<Items> allItems() {
		return itemDAO.allItems();
	}

}
