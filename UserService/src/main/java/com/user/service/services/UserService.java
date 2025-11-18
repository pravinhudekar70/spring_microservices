package com.user.service.services;

import java.util.List;

import com.user.service.entity.User;

public interface UserService {

	
	//user operations 
	
	//create 
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	// get single user of given userId
	User getUser(String userId);
	
	//delete user using userId
	void deleteUser(String userId);
	
	//update user 
	User updateUser(User user);
	
}
