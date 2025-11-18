package com.rating.service;

import java.util.List;

import com.rating.entity.Rating;

public interface RatingService {
	
	//create
	 Rating createRating(Rating rating);
	 
	 //get by id
	Rating getById(String ratingId);
	
	//get all rating 
	 List<Rating> getAllRating();
	
	//get all by userId
	List<Rating> getAllByUserId(String userId);
	
	
	// get all by hotelId
	List<Rating> getAllByHotelId(String hotelId);

}
