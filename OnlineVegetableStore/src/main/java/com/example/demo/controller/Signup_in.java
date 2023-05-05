package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Customer;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/VegStore")
public class Signup_in {
    @PostMapping("/customerRegister")
	public ResponseEntity<String> customerRegister(@Valid @RequestBody Customer cus ){
		return new ResponseEntity<>("Customer added sucessfully",HttpStatus.ACCEPTED);
	}
    
    @GetMapping("/customerLogin")
    public ResponseEntity<String> customerLogin( @Valid @RequestBody Customer cus)
    {
    	return new ResponseEntity<String>("", HttpStatus.ACCEPTED);
    }
    
    
    
    @PostMapping("/adminRegister")
    public ResponseEntity<String>  adminRegister( @Valid  @RequestBody Admin admin) {
    	
    	return new ResponseEntity<String>("",HttpStatus.ACCEPTED);
    }
    
    
    @GetMapping("/adminLogin")
     public ResponseEntity<String>  adminLogin(@Valid @RequestBody Admin admin){
    	
    	return new ResponseEntity<String>("",HttpStatus.ACCEPTED);
    }
}
