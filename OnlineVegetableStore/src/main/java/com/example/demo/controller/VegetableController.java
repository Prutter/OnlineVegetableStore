package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.VegetableServices;
import com.example.demo.entities.*;

@RestController
public class VegetableController {
	
	@Autowired
	public VegetableServices vegetableservice;
	
	@PostMapping("/addVegetable")
	public ResponseEntity<Vegetable> addVegetable(@RequestBody Vegetable veg) {
		
		Vegetable vegetable = vegetableservice.addVegetable(veg);
		
		return new ResponseEntity<>(vegetable,HttpStatus.CREATED);
	}
	
	@PostMapping("/updateVegetable/{vegID}")
	public ResponseEntity<Vegetable> updateVegetable(@PathVariable Integer vegID,@RequestBody Vegetable veg) {
		
		Vegetable vegetable = vegetableservice.updateVegetable(vegID, veg);
		
		return new ResponseEntity<>(vegetable,HttpStatus.OK);
	}
	
	@DeleteMapping("/removeVegetable/{vegeId}")
	public ResponseEntity<Vegetable> removeVegetable(@PathVariable Integer vegeId) {
		
		Vegetable vegetable = vegetableservice.removeVegetable(vegeId);
		
		return new ResponseEntity<>(vegetable,HttpStatus.OK);
		
	}
	
	@GetMapping("/viewAllVegetable")
	public ResponseEntity<List<Vegetable>> viewAllVegetable(){
		
		List<Vegetable> veglist = vegetableservice.viewAllVegetable();
		
		return new ResponseEntity<>(veglist,HttpStatus.OK);
		
	}
	
	@GetMapping("/viewVegetablesByCategory/{type}")
	public ResponseEntity<List<Vegetable>> viewVegetablesByCategory(@PathVariable String type){
		
		List<Vegetable> veglist = vegetableservice.viewVegetablesByCategory(type);
		
		return new ResponseEntity<>(veglist,HttpStatus.OK);
	}
	
	@GetMapping("/viewVegetablesByName/{name}")
	public ResponseEntity<List<Vegetable>> viewVegetablesByName(@PathVariable String name){
		
        List<Vegetable> veglist = vegetableservice.viewVegetablesByName(name);
		
		return new ResponseEntity<>(veglist,HttpStatus.OK);
		
	}
	
}
