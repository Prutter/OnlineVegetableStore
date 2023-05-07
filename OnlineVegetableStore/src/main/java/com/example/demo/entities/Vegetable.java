package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
public class Vegetable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vegId;
	private String name;
	private String type;
	private double price;
	private Integer quantity;
	private String url;
	
	public Vegetable(Integer vegId, String name, String type, double price, Integer quantity, String url, Cart cart) {
		super();
		this.vegId = vegId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.url = url;
		this.cart = cart;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	public Vegetable() {};
	
	
	public Integer getVegId() {
		return vegId;
	}
	public void setVegId(Integer vegId) {
		this.vegId = vegId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
