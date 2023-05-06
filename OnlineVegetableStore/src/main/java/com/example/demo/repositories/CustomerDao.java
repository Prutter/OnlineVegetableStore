package com.example.demo.repositories;
import com.example.demo.entities.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {
	public Optional<Customer> findByEmailId(String emailId);
	
	public List<Customer> findByName(String name);
	public Optional<Customer> findByMobileNumber(String mobileNumber);
}
