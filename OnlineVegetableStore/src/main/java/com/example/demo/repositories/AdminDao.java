package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Admin;

public interface AdminDao  extends JpaRepository<Admin, Integer>{
 public Optional<Admin> findByPhone(String number);
 public Optional<Admin> findByUserName(String name);
 public Optional<Admin> findByEmail(String email);
}
