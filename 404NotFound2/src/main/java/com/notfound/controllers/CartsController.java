package com.notfound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.beans.Carts;
import com.notfound.service.CartsService;

@RestController // combines @Controller and @ResponseBody
@RequestMapping(value="/carts")
public class CartsController {
	
	private CartsService cartsService;
	
	@Autowired 
	public CartsController(CartsService cartsService) {
		this.cartsService = cartsService;
	}
	@CrossOrigin
	@GetMapping(value="/{userId}")
	public ResponseEntity<Carts> getCartById(@PathVariable int userId){
		Carts c = cartsService.getCartById(userId);
		if (c == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> createNewCartItem(@RequestBody Carts cart){
		ResponseEntity<String> resp = null;
		try {
			cartsService.createNewCartItem(cart);
			resp = new ResponseEntity<>("CART CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE CART", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	@CrossOrigin
	@PutMapping
	public ResponseEntity<String> editCart(@RequestBody Carts cart){
		ResponseEntity<String> resp = null;
		try {
			cartsService.editCart(cart);
			resp = new ResponseEntity<>("CART UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE CART", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}	
	@CrossOrigin
	@DeleteMapping
	public ResponseEntity<String> deleteCart(@RequestBody Carts cart){
		ResponseEntity<String> resp = null;
		try {
			cartsService.deleteCart(cart);
			resp = new ResponseEntity<>("CART DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO DELETE CART", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
}
