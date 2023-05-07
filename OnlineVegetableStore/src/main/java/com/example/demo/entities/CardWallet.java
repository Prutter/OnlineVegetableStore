package com.example.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CardWallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cardWalletId;
	private Integer customerId;
	private String cardNo;
	private Integer cvv;
	private Integer cardAmount;
	private Integer walletAmount;
	private LocalDate expiryDate;
}
