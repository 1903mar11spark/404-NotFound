package com.notfound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.beans.User;
import com.notfound.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		User u = userService.getUserById(id);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User user){
		ResponseEntity<String> resp = null;
		try {
			userService.createUser(user);
			resp = new ResponseEntity<>("USER CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE USER", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@PutMapping
	public ResponseEntity<String> updateUser(@RequestBody User user){
		ResponseEntity<String> resp = null;
		try {
			userService.updateUser(user);
			resp = new ResponseEntity<>("USER UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE USER", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}	

}


