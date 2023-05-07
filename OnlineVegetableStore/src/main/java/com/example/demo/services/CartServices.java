package com.example.demo.services;

import com.example.demo.entities.Vegetable;
import com.example.demo.entities.*;
import java.util.*;

public interface CartServices {
	
	public Cart addToCart(Vegetable vegetable,Integer cid);
	
	public Cart IncreaseVegetableQuantity(Integer vegetableId, Integer quantity, Integer cid);
	
	public Cart DecreaseVegetableQuantity(Integer vegetableId, Integer quantity, Integer cid);
	
	public Cart RemoveVegetable(Integer vegetableId , Integer cid);
	
	public Cart RemoveAllVegetables(Integer cid);
	
	public List<Vegetable> viewAllVegetables(Integer cid);
}
