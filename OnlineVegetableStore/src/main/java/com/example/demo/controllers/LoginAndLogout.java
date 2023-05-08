package com.example.demo.controllers;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.*;
import com.example.demo.services.*;

@RestController
public class LoginAndLogout {
	
	@Autowired
	UserLoginServices uls;

	@PostMapping("/organicoasis/Login")
	public ResponseEntity<LoggedSession> signIn(@RequestBody LoginCredential logged) throws LoginException{
		return new ResponseEntity<LoggedSession>(uls.logIntoAccount(logged),HttpStatus.OK);
	}
	
	@PostMapping("/organicoasis/Logout/{k}")
	public ResponseEntity<String> signIn(@PathVariable("k") String key) throws LoginException{
		return new ResponseEntity<String>(uls.logOutFromAccount(key),HttpStatus.OK);
	}
	
}
