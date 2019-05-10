package com.notfound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.beans.Carts;
import com.notfound.service.CartsService;
import com.notfound.service.ItemService;

@RestController // combines @Controller and @ResponseBody
@RequestMapping(value="/carts")
public class CartsController {
	
	private CartsService cartsService;
	
	@Autowired 
	public CartsController(CartsService cartsService) {
		this.cartsService = cartsService;
	}
	
	
}




//public void createNewCartItem (Carts cart);
//public void deleteCart(Carts cart);
//public void editCart(Carts cart);
//public Carts getCartById(int userId);