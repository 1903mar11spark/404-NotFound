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

import com.notfound.beans.Review;
import com.notfound.service.ReviewService;

@RestController
@RequestMapping(value = "/review")
public class ReviewController {
	
	private ReviewService reviewService;
	
	@Autowired
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	@CrossOrigin
	@GetMapping(value ="/{id}")
	public ResponseEntity<Review> getReview(@PathVariable int userId) {
		Review r = reviewService.getReview(userId);
		if (r == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<> (r, HttpStatus.OK);
		}
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> createReview(@RequestBody Review review){
		ResponseEntity<String> resp = null;
		try {
			reviewService.createReview(review);
			resp = new ResponseEntity<>("REVIEW CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE REVIEW", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	@CrossOrigin
	@PutMapping
	public ResponseEntity<String> updateReview(@RequestBody String rant){
		ResponseEntity<String> resp = null;
		try {
			reviewService.editReview(rant);
			resp = new ResponseEntity<>("REVIEW UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE REVIEW", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	@CrossOrigin
	@DeleteMapping
	public ResponseEntity<String> deleteReview(@RequestBody Review review){
		ResponseEntity<String> resp = null;
		try {
			reviewService.deleteReview(review);
			resp = new ResponseEntity<>("REVIEW DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO DELETE REVIEW", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
