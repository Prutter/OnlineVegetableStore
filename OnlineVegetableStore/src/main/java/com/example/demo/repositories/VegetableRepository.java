package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Vegetable;

public interface VegetableRepository extends JpaRepository<Vegetable, Integer>{
	
	public List<Vegetable> findByName(String name);

	public List<Vegetable> findByType(String type);
}
