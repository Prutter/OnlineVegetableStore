package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.*;
import com.example.demo.exceptions.CardException;
import com.example.demo.services.CardServices;

@RestController
public class CardController {
	
	@Autowired(required = false)
	private CardServices cardservices;
	
	@PostMapping("/organicoasis/addcard/{id}")
	public ResponseEntity<CardWallet> cardIntegration(@RequestBody CardWallet card,@PathVariable("id") Integer cid) {
		CardWallet cardwallet = cardservices.addCard(card, cid);
		return new ResponseEntity<CardWallet>(cardwallet, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/orgaincoasis/transaction/{cid}/{amount}")
	public ResponseEntity<CardWallet> addToWallet(@RequestBody CardWallet card ,@PathVariable("amount") Integer Amount,@PathVariable("cid") Integer cid){
		CardWallet cardwallet = cardservices.addCard(card, cid);
		return new ResponseEntity<CardWallet>(cardwallet, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/organicoasis/getcard/{cid}")
	public ResponseEntity<CardWallet> getCard(@PathVariable("cid") Integer cid) {
		CardWallet wallet;
		try {
			wallet = cardservices.getCardDetails(cid);
		} catch (CardException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(wallet, HttpStatus.FOUND);
	}
}
