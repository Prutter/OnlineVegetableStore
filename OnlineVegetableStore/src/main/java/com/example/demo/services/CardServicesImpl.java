package com.example.demo.services;
import java.util.Optional;

import com.example.demo.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.*;
import com.example.demo.repositories.CardRepository;
import com.example.demo.repositories.CustomerDao;

@Service
public class CardServicesImpl implements CardServices{
	
	@Autowired
	private CustomerDao customerRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	public CardWallet addCard(CardWallet cardwallet, Integer cid) throws CustomerException{
		Optional<Customer> opt = customerRepository.findByUserId(cid);
		if(opt == null)
			throw new CustomerException("Customer with the given id does not exist");
		Customer customer = opt.get();
		cardwallet.setUserId(customer.getUserId());
		cardwallet.setCardAmount(15000);
		CardWallet cardWallet = cardRepository.save(cardwallet); 
		return cardWallet;
	}
	
	public Integer AddAmountToWallet(CardWallet cardWallet, Integer cid, Integer amount) throws CardException {
		Optional<Customer> opt = customerRepository.findByUserId(cid);
		if(opt == null)
			throw new CustomerException("Customer with the given id does not exist");
		Customer customer = opt.get();		
		CardWallet card = cardRepository.findByUserId(cid);
		if(card.getCardAmount() < amount)
			throw new CardException("Insufficient balance in your bank amount.");
		card.setCardAmount(card.getCardAmount()-amount);
		card.setWalletAmount(card.getWalletAmount()+ amount);
		return amount;
	}

	@Override
	public CardWallet getCardDetails(Integer cid) throws CardException {
		CardWallet wallet = cardRepository.findByUserId(cid);
		if(wallet == null)
			throw new CardException("Card is not found with this customer id");
		return wallet;
	}
}
