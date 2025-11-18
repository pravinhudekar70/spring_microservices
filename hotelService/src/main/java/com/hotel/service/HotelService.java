package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {
 
	
	//create
	
	public Hotel createHotel (Hotel hotel);
	
	//getAll
	public List<Hotel> getAllHotel();
	
	//get single
	public Hotel getHotelById (String id);
}
