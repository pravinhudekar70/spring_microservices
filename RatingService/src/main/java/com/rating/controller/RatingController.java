package com.rating.controller;

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

import com.rating.entity.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	@PostMapping("/save")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating ){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getById(@PathVariable String ratingId){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getById(ratingId));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Rating>> getAllRating(){
		return ResponseEntity.ok(ratingService.getAllRating());
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity <List<Rating>> getAllByUserId(@PathVariable String userId){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllByUserId(userId));
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity <List<Rating>> getAllByHotelId(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllByHotelId(hotelId));
	}
	
	

}
