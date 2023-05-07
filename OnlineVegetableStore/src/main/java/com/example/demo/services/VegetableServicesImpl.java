package com.example.demo.services;
import com.example.demo.entities.*;
import com.example.demo.exceptions.VegetableException;
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.VegetableRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VegetableServicesImpl implements VegetableServices{
	
	@Autowired
	public VegetableRepository vegetablerepository;
	@Autowired
	public CartRepository cartrepository;
	
	@Override
	public Vegetable addVegetable(Vegetable veg) {
		Vegetable vege = vegetablerepository.save(veg);	
		return vege;
	}
	
	
	@Override
	public Vegetable updateVegetable(Integer vegID,Vegetable veg) {
		Optional<Vegetable> veges = vegetablerepository.findById(vegID);
		if(veges.isPresent()) {
			Vegetable vegs = veges.get();
			vegs.setName(veg.getName());
			vegs.setPrice(veg.getPrice());
			vegs.setQuantity(veg.getQuantity());
			vegs.setType(veg.getType());
			
			return vegetablerepository.save(vegs);	
		}else {
			throw new VegetableException("Vegetable Not Found");
		}
	}
	
	
	@Override
	public Vegetable removeVegetable(Integer vegeId) {
		Optional<Vegetable> vege = vegetablerepository.findById(vegeId);
		if(vege.isPresent()) {
			Vegetable veg = vege.get();
			vegetablerepository.delete(veg);
			return veg;	
		}else {
			throw new VegetableException("Vegetable Not Found");
		}	
	}
	
	
	@Override
	public List<Vegetable> viewAllVegetable() {
		List<Vegetable> vegList = vegetablerepository.findAll();
		if(vegList.isEmpty()) {
			throw new VegetableException("No vegetable Found");
		}	
		return vegList;
	}
	
	
	@Override
	public List<Vegetable> viewVegetablesByCategory(String type) {
		List<Vegetable> vegBycategory = vegetablerepository.findByType(type);
		if(vegBycategory.isEmpty()) {
			throw new VegetableException("No vegetable Found");
		}	
		return vegBycategory;
	}
	
	
	@Override
	public List<Vegetable> viewVegetablesByName(String name) {
        List<Vegetable> vegByname = vegetablerepository.findByName(name);
		if(vegByname.isEmpty()) {
			throw new VegetableException("No vegetable Found");
		}
		return vegByname;
	}

}
