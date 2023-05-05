package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.LoggedSession;
import com.example.demo.exceptions.AuthorizationException;
import com.example.demo.repositories.LoggedSessionRepo;

public class AuthorizationServicesImpl implements AuthorizationServices{

	@Autowired
	LoggedSessionRepo loggedSessionRepo;
	
	@Override
	public boolean Auth(Integer id, String key)throws AuthorizationException{
		Optional<LoggedSession> op1=loggedSessionRepo.findById(id);
		if(!op1.isPresent()) throw new AuthorizationException("Authorization Error (User not logedin)");
		if(!op1.get().getUniquekey().equals(key))throw new AuthorizationException("Authorization Error (Enter correct Key)");
		return true;
	}

}
