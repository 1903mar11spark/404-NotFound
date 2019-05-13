package com.notfound.controllers;

import org.springframework.web.bind.annotation.*;

import com.notfound.service.UserService;
import com.notfound.service.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController 
@RequestMapping(value = "/user")
public class UserController {

	private UserServices us = new UserService();
	
//	@GetMapping(value="/build/{?}")
//	public ResponseEntity<List<Author>> getAllAuthors() {
//		return new ResponseEntity<>us. HttpStatus.OK);
//	}
}
