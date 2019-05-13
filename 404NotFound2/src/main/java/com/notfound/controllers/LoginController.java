package com.notfound.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.beans.Login;
import com.notfound.service.LoginService;


@RestController // combines @Controller and @ResponseBody
@RequestMapping(value="/login")
public class LoginController {

	private LoginService loginService;
	@Autowired 
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	@CrossOrigin
	@GetMapping(value="/{userName}/{password}")
	public ResponseEntity<Integer> gettingUserId(@PathVariable String userName, @PathVariable String password){
		int i = loginService.gettingUserId(userName, password);
		System.out.println(i);
		if (i == 0) {
			return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(i, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> createLogin(@RequestBody Login login){
		ResponseEntity<String> resp = null;
		try {
			loginService.createLogin(login);
			resp = new ResponseEntity<>("LOGIN CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE LOGIN", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	@CrossOrigin
	@PutMapping
	public ResponseEntity<String> editLogin(@RequestBody Login login){
		ResponseEntity<String> resp = null;
		try {
			loginService.editLogin(login);
			resp = new ResponseEntity<>("LOGIN UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE LOGIN", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	@CrossOrigin
	@GetMapping(value="/all")
	public ResponseEntity<List<Login>> getAllItems() {
		return new ResponseEntity<>(loginService.allLogins(), HttpStatus.OK);
	}
}


