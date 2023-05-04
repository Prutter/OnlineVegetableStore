package com.example.demo.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.*;
import com.example.demo.exceptions.*;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) throws UserException {
		User existingUser= userRepository.findByuserName(user.getUserName());		
		if(existingUser != null) throw new UserException("Username already exist!. Try another one.");
		return userRepository.save(user);
	}

	@Override
	public User deleteUser(Integer userId) throws UserException {
		Optional<User> existingUser= userRepository.findById(userId);
		if(!existingUser.isPresent()) throw new UserException("Username not exist! Check once again and try later.");
		userRepository.delete(existingUser.get());
		return existingUser.get();
	}

	@Override
	public User UpdateUser(Integer userId, User user) throws UserException {
		Optional<User> existingUser= userRepository.findById(userId);
		if(!existingUser.isPresent()) throw new UserException("Username not exist! Check once again and try later.");
		return userRepository.save(user);
	}

}
