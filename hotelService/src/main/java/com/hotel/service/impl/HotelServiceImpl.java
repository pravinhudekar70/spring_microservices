package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repo.HotelRepo;
import com.hotel.service.HotelService;
import com.hotel.share.IdGenerator;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepo hotelRepo;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String randomId = IdGenerator.generateId("HOT");	
//		String randomId = UUID.randomUUID().toString();
		hotel.setId(randomId);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
		return hotelRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException("Hotel not found with given id !! "));
	}

		
	
}
