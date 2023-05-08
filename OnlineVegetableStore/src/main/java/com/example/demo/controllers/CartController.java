package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Vegetable;
import com.example.demo.entities.*;
import com.example.demo.services.CartServices;

@RestController
public class CartController {

	@Autowired
	private CartServices cartservices;
	
	@GetMapping("/organicoasis/{id}/{vid}")
	public ResponseEntity<Cart> addToCart(@PathVariable("vid") Integer vid,@PathVariable("id") Integer cid){
		Cart cart = cartservices.addToCart(vid, cid);
		return new ResponseEntity<>(cart, HttpStatus.CREATED);
	}
	
	@PutMapping("/organicoasis/increase/{cid}/{quantity}/{vid}")
	public ResponseEntity<Cart> addQuantity(@PathVariable("vid") Integer vegetableId,@PathVariable("quantity") Integer quantity,@PathVariable("cid") Integer cid){
		Cart cart = cartservices.IncreaseVegetableQuantity(vegetableId, quantity, cid);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@PutMapping("/organicoasis/decrease/{cid}/{quantity}/{vid}")
	public ResponseEntity<Cart> removeQuantity(@PathVariable("vid") Integer vegetableId,@PathVariable("quantity") Integer quantity,@PathVariable("cid") Integer cid){
		Cart cart = cartservices.DecreaseVegetableQuantity(vegetableId, quantity, cid);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@GetMapping("/organicoasis/view/{cid}")
	public ResponseEntity<List<Vegetable>> getAll(@PathVariable("cid") Integer id){
		List<Vegetable> list =  cartservices.viewAllVegetables(id);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/organicoasis/deleteall/{cid}")
	public ResponseEntity<Cart> deleteAll(@PathVariable("cid") Integer id){
		Cart cart=  cartservices.RemoveAllVegetables(id);
		return new ResponseEntity<>(cart , HttpStatus.ACCEPTED);
	} 
	
	@GetMapping("/organicoasis/deletevege/{cid}/{vegeid}")
	public ResponseEntity<Cart> deletevegetable(@PathVariable("cid") Integer cid, @PathVariable("vegeid") Integer vegid){
		Cart cart=  cartservices.RemoveVegetable(vegid, cid);
		return new ResponseEntity<>(cart , HttpStatus.ACCEPTED);
	}
}
