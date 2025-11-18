package com.rating.service.impl;

import java.util.List;
import com.rating.share.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entity.Rating;
import com.rating.exception.ResourceNotFoundException;
import com.rating.repo.RatingRepo;
import com.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepo ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		String random = IdGenerator.generateId("RAT");	
		rating.setRatingId(random);
		return ratingRepo.save(rating);
	}

	@Override
	public Rating getById(String ratingId) {
		return ratingRepo.findById(ratingId).orElseThrow(() ->new ResourceNotFoundException("Rating not found with given id !! "));
	}

	@Override
	public List<Rating> getAllRating() {
		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getAllByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

	

}
