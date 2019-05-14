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
	public List<Items> getItemByType(int itemType) {
		return itemDAO.getItemByType(itemType);
	};
	public List<Items> getItemByPrices(int price1, int price2) {
		return itemDAO.getItemByPrices(price1, price2);
	};
	public void setNewItem(Items item) {
		itemDAO.setNewItem(item);
	};
	public List<Items> allItems() {
		return itemDAO.allItems();
	}
	public List<Items> getItemByCondition(boolean condition) {
		return itemDAO.getItemByCondition(condition);
	}
	public List<Items> getItemByUser(int userId) {
		return itemDAO.getItemByUser(userId);
	};

}
