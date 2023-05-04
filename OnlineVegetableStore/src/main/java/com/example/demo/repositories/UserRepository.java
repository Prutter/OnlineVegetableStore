package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.*;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByuserName(String username);
}
