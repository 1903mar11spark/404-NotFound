package com.notfound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
