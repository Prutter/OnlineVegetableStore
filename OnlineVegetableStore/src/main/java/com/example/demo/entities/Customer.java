package com.example.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@PrimaryKeyJoinColumn(name= "customerid")
@EqualsAndHashCode(callSuper=false)
public class Customer  extends User{

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addid")
    private Address address;
    
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "cartid")
    private Cart cart;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer(Address address, Cart cart) {
		super();
		this.address = address;
		this.cart = cart;
	}

	public Customer() {
		super();
		this.cart = new Cart(this.getUserId());
	}
    
    
}
