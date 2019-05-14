package com.notfound.controllers;

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

import com.notfound.beans.ShaneBucks;
import com.notfound.service.ShaneBucksService;

@RestController
@RequestMapping(value = "shaneBucks")
public class ShaneBucksController {
	
	private ShaneBucksService shaneBucksService;
	@Autowired
	public ShaneBucksController(ShaneBucksService shaneBucksService) {
		this.shaneBucksService = shaneBucksService;
	}
	
	@CrossOrigin
	@GetMapping(value="/{userId}")
	public ResponseEntity<Double> getBalance(@PathVariable int userId){
		double s = shaneBucksService.getBalance(userId);
		if (s == 0) {
			return new ResponseEntity<>(0.00, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> makeNewBalance(@RequestBody ShaneBucks shane){
		ResponseEntity<String> resp = null;
		try {
			shaneBucksService.makeNewBalance(shane);
			resp = new ResponseEntity<>("SHANE CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE SHANE", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@CrossOrigin
	@PutMapping
	public ResponseEntity<String> setBalance(@RequestBody int balance, int userId){
		ResponseEntity<String> resp = null;
		try {
			shaneBucksService.setBalance(balance, userId);
			resp = new ResponseEntity<>("SHANE UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE SHANE", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}

