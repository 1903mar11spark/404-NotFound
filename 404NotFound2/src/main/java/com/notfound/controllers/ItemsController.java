package com.notfound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Items> getById(@PathVariable int id){
		Items i = itemService.getItemById(id);
		if (i == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(i, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/type/{type}")
	public ResponseEntity<Items> getById(@PathVariable short itemType){
		Items i = itemService.getItemByType(itemType);
		if (i == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(i, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/price/{price}")
	public ResponseEntity<Items> getById(@PathVariable double price){
		Items i = itemService.getItemByPrice(price);
		if (i == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(i, HttpStatus.OK);
		}
	}
	
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

}
