package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;
import com.example.demo.entities.*;
import com.example.demo.entities.LoggedSession;
import com.example.demo.entities.LoginCredential;
import com.example.demo.repositories.LoggedSessionRepo;
import com.example.demo.repositories.UserRepository;

@Service
public class UserLoginServicesImpl implements UserLoginServices{
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private LoggedSessionRepo lsr;

	@Override
	public LoggedSession logIntoAccount(LoginCredential dto) throws LoginException {
			User existingUser= ur.findByuserName(dto.getUsername());		
			if(existingUser == null) throw new LoginException("Please Enter a valid Username");
			if(!existingUser.getPassword().equals(dto.getPassword())) throw new LoginException("Please Enter a valid password");
			Optional<LoggedSession> validLoggedSessionOpt =  lsr.findById(existingUser.getUserId());
			if(validLoggedSessionOpt.isPresent()) return validLoggedSessionOpt.get();
			String key= existingUser.getRole()+"."+generateRandomChars(16);
			LoggedSession currentUserSession = new LoggedSession(existingUser.getUserId(),key,existingUser.getRole(),LocalDateTime.now());
			lsr.save(currentUserSession);
			return currentUserSession;
	
	}
	public String generateRandomChars(int length) {
		String candidateChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < length; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
	    }
	    return sb.toString();
	}
	@Override
	public String logOutFromAccount(String key) throws LoginException {
		System.out.println("hello"+key);
		LoggedSession validLoggedSession = lsr.findByuniquekey(key);
		if(validLoggedSession==null) throw new LoginException("User Not Logged ");
		lsr.delete(validLoggedSession);
		return "Logged Out !";
	}

}
