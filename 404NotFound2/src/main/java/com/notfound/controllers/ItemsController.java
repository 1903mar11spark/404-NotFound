package com.notfound.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.service.ItemService;
import com.notfound.beans.Items;

@RestController // combines @Controller and @ResponseBody
@RequestMapping(value="/items")
public class ItemsController {
	
	private ItemService itemService;
	
	@Autowired 
	public ItemsController(ItemService itemService) {
		this.itemService = itemService;
	}
	@CrossOrigin
	@GetMapping(value="/{id}")
	public ResponseEntity<Items> getById(@PathVariable int id){
		Items i = itemService.getItemById(id);
		if (i == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(i, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@GetMapping(value="/type/{itemType}")
	public ResponseEntity<List<Items>> getByType(@PathVariable int itemType) {
		return new ResponseEntity<>(itemService.getItemByType(itemType), HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping(value="/price/{price1}/{price2}")
	public ResponseEntity<List<Items>> getByPrice(@PathVariable int price1, @PathVariable int price2){
		return new ResponseEntity<>(itemService.getItemByPrices(price1, price2), HttpStatus.OK);
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> createItem(@RequestBody Items item){
		ResponseEntity<String> resp = null;
		try {
			itemService.setNewItem(item);
			resp = new ResponseEntity<>("ITEM CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE ITEM", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	@CrossOrigin
	@GetMapping(value="/all")
	public ResponseEntity<List<Items>> getAllItems() {
		return new ResponseEntity<>(itemService.allItems(), HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping(value="/condition/{condition}")
	public ResponseEntity<List<Items>> getByCondition(@PathVariable boolean condition) {
		return new ResponseEntity<>(itemService.getItemByCondition(condition), HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping(value="/user/{userId}")
	public ResponseEntity<List<Items>> getByUser(@PathVariable int userId) {
		return new ResponseEntity<>(itemService.getItemByUser(userId), HttpStatus.OK);
	}

}
