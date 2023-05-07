package com.example.demo.services;
import com.example.demo.entities.*;
import java.util.*;

public interface VegetableServices {
	public Vegetable addVegetable(Vegetable veg);
	public Vegetable updateVegetable(Integer vegID,Vegetable veg);
	public Vegetable removeVegetable(Integer vegeId);
	public List<Vegetable> viewAllVegetable();
	public List<Vegetable> viewVegetablesByCategory(String type);
	public List<Vegetable> viewVegetablesByName(String name);
}
