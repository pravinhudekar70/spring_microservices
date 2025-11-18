package com.user.service.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entity.Rating;

@FeignClient(name = "RatingService")
public interface RatingService {
	@GetMapping("/ratings/users/{userId}")
	List<Rating> getRating (@PathVariable String  userId );
}
