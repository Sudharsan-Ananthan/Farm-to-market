package com.dnapass.training.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dnapass.training.entity.User;
import com.dnapass.training.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(new User(user.getMobileNumber(),user.getState(),user.getCity(),user.getPincode(),user.getRole(),user.getUsername()));
	}
	
	public User findUser(Integer userId) {
		User findingUser = userRepo.findById(userId).get();
		return findingUser;
	}
}
