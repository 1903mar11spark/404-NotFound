package com.notfound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.DAO.ItemsDAO;
import com.notfound.DAO.ItemsDAOImpl;
import com.notfound.beans.Items;
import com.notfound.service.ItemServices;
import com.notfound.service.ItemsService;

@RestController // combines @Controller and @ResponseBody
@RequestMapping(value="/items")
public class ItemsController {
	
	private ItemServices idi = new ItemsService();
	@GetMapping(value="/{id}")
	public ResponseEntity<Items> getById(@PathVariable int id){
		Items i = idi.getItemById(id);
		if (i == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(i, HttpStatus.OK);
		}
	}

}
