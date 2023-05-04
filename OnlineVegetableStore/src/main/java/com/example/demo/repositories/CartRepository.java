package com.example.demo.repositories;
import com.example.demo.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	public Cart findBycustomerId(Integer customerId);
}
