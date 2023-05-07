package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Admin;
@Repository
public interface AdminDao  extends JpaRepository<Admin, Integer>{
 public Optional<Admin> findByPhone(String number);
 public Optional<Admin> findByName(String name);
 public Optional<Admin> findByEmail(String email);
 
}
