package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.CardWallet;

public interface CardRepository extends JpaRepository<CardWallet, Integer>{
	public CardWallet findByUserId(Integer customerId);
}
