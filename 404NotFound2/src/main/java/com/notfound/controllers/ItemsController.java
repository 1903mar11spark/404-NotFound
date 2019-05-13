package com.notfound.controllers;

import java.util.List;

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
	
	@GetMapping(value="/type/{itemType}")
	public ResponseEntity<Items> getByType(@PathVariable short itemType){
		Items t = itemService.getItemByType(itemType);
		if (t == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(t, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/price/{price}")
	public ResponseEntity<Items> getByPrice(@PathVariable double price){
		Items p = itemService.getItemByPrice(price);
		if (p == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(p, HttpStatus.OK);
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
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Items>> getAllItems() {
		return new ResponseEntity<>(itemService.allItems(), HttpStatus.OK);
	}

}
