package com.example.demo.controllers;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.*;
import com.example.demo.services.*;
import com.example.demo.exceptions.*;

@RestController
public class LoginAndLogout {
	
	@Autowired
	UserLoginServices uls;
	
	@Autowired(required = false)
	AuthorizationServicesImpl as; 
	
	@PostMapping("/organicoasis/Login")
	public ResponseEntity<LoggedSession> signIn(@RequestBody LoginCredential logged) throws LoginException{
		return new ResponseEntity<LoggedSession>(uls.logIntoAccount(logged),HttpStatus.OK);
	}
	
	@PostMapping("/organicoasis/Logout")
	public ResponseEntity<String> signIn(@RequestBody String key) throws LoginException{
		return new ResponseEntity<String>(uls.logOutFromAccount(key),HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<String> welcome(@PathVariable Integer id,@RequestHeader ("Auth") String key) throws LoginException, AuthorizationException{
		String str=as.Auth(id,key)?"Verified":"Not Verified";
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
}
