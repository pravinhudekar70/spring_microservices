package com.user.service.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.external.service.HotelService;
import com.user.service.external.service.RatingService;
import com.user.service.repo.UserRepo;
import com.user.service.services.UserService;
import com.user.service.share.IdGenerator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	@Override
	public User saveUser(User user) {
		
		// Generate unique user id
		String userRandomId = IdGenerator.generateId("USR");
		//String userRandomId = UUID.randomUUID().toString();
		
		user.setUserId(userRandomId);
		return  userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		List<User> userList =userRepo.findAll();
		return userList.stream().map(user ->{
			List<Rating> userRatingList  = ratingService.getRating(user.getUserId());
			user.setRatings(userRatingList);
			return user;
		}).collect(Collectors.toList());
	}

	@Override
	public User getUser(String userId) {
		
		User user =	userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on serve !! : "+userId));		
//		Rating [] userRatings = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+ user.getUserId(), Rating [].class);	
		
//		List<Rating> userRatingList = List.of(userRatings);
		List<Rating> userRatingList = ratingService.getRating(user.getUserId());
		
	List<Rating> ratingList = userRatingList.stream().map(rating ->{
			//api call to hotel service to get the hotel
//			Hotel hotel = restTemplate.getForObject("http://HOTELSERVICE/hotels/"+ rating.getHotelId() , Hotel.class);
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());

			//set the hotel to rating
			rating.setHotel(hotel);
			
			//return the rating
			return rating;
			
		}).collect(Collectors.toList());
		
		
		
		user.setRatings(ratingList);		
		return user;
	
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
