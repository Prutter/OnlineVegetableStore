package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Git;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Customer;
import com.example.demo.services.AdminService;
import com.example.demo.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/VegStore")
public class Signup_in {
	
	@Autowired
	private CustomerService  service;
	
	@Autowired
	private AdminService adminService;
	
    @PostMapping("/customerRegister")
	public ResponseEntity<Customer> customerRegister(@Valid @RequestBody Customer cus ){
    	Customer res =  service.addCustomer(cus);
    	
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
	}
    
    


    
    @PostMapping("/adminRegister")
    public ResponseEntity<Admin>  adminRegister( @Valid  @RequestBody Admin admin) {
    	
    	Admin res = adminService.addAdmin(admin);
    	return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }
    
    
}
