package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.*;
import com.example.demo.entities.Address;
import com.example.demo.repositories.AddressRepo;
import com.example.demo.repositories.AdminDao;
import com.example.demo.repositories.CustomerDao;
import com.example.demo.repositories.UserRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepo ar;
	
	@Autowired
	private AdminDao as;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private CustomerDao cd;
	
	public Address addAdminAddress(Address a, Integer cid) {
		Optional<Admin> opt = as.findById(cid);
		Admin c = opt.get();
		c.setUserId(cid);
		as.save(c);
		a.setUser(cid);
		Address address = ar.save(a);
		return address;
	}
	
	public Address addCustomerAddress(Address a, Integer cid) {
		Optional<Customer> opt = cd.findById(cid);
		Customer c = opt.get();
		c.setUserId(cid);
		cd.save(c);
		a.setUser(cid);
		Address address = ar.save(a);
		return address;
	}
	
	public User getcus(Integer id) {
		Optional<Address> a = Optional.ofNullable(ar.findByUser(id));
		Address address = a.get();
		Optional<User> c = ur.findById(address.getUser());
		return c.get(); 
	}
	
	public Address updateAddress(Address a) {
		Address address = ar.save(a);
		return address;
	}
	
	public Address getAddress(Integer id) {
		Optional<Address> a = Optional.ofNullable(ar.findByUser(id));
		return a.get();
	}
}
