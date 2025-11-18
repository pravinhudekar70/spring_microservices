package com.user.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.entity.User;

public interface UserRepo extends JpaRepository<User, String> {

}
