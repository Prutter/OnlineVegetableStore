package com.example.demo.repositories;
import com.example.demo.entities.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {
public Optional<Customer> findByEmail(String emailId);
public Optional<Customer> findByUserId(Integer id);
public List<Customer> findByUserName(String name);
public Optional<Customer> findByPhone(String mobileNumber);
public Optional<Customer> findByUserNameAndPassword(String username,String password);
}
