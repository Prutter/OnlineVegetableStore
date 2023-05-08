package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Address;
import com.example.demo.entities.User;
import com.example.demo.services.AddressService;
import com.example.demo.services.CustomerService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService as;
	
	@Autowired
	private CustomerService cs;
	
	@PostMapping("/organicoasis/registeradminaddress/{id}")
	public ResponseEntity<String> addAdminAddress(@RequestBody Address a, @PathVariable("id") Integer id){
		as.addAdminAddress(a, id);
		return new ResponseEntity<String>("added", HttpStatus.OK);
	}
	
	@PostMapping("/organicoasis/registercustomeraddress/{id}")
	public ResponseEntity<String> addcustomerAddress(@RequestBody Address a, @PathVariable("id") Integer id){
		as.addCustomerAddress(a, id);
		return new ResponseEntity<String>("added", HttpStatus.OK);
	}
	
	@GetMapping("/organicoasis/mapcustomer/{id}")
	public ResponseEntity<User> gets(@PathVariable("id") Integer id){
		User u = as.getcus(id);
		return new ResponseEntity<User>(u, HttpStatus.FOUND);
	}
	
	
	@GetMapping("/organicoasis/getaddress/{id}")
	public ResponseEntity<Address> getAddress(@PathVariable("id") Integer id){
		Address a = as.getAddress(id);
		return new ResponseEntity<Address>(a, HttpStatus.OK);
	}
}
