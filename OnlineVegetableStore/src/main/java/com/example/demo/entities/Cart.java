package com.example.demo.entities;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	@Column(unique = true)
	private Integer customerId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cart_id")
	private List<Vegetable> listOfVegetables;

	public Cart() {
		super();
	}

	public Cart(Integer customerId, List<Vegetable> listOfVegetables) {
		super();
		this.customerId = customerId;
		this.listOfVegetables = listOfVegetables;
	}

	public Cart(Integer cartId, Integer customerId, List<Vegetable> listOfVegetables) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.listOfVegetables = listOfVegetables;
	}
}