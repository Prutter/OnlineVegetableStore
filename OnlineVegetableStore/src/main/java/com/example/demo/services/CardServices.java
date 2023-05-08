package com.example.demo.services;

import com.example.demo.entities.CardWallet;
import com.example.demo.exceptions.CardException;
import com.example.demo.exceptions.CustomerException;

public interface CardServices {
	
	public CardWallet addCard(CardWallet cardwallet, Integer cid) throws CustomerException;
	
	public Integer AddAmountToWallet(Integer cid, Integer amount) throws CardException;
	
	public CardWallet getCardDetails(Integer cid) throws CardException;
}
