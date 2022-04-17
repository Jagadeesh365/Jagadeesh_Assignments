package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.CreditCard;
import com.springrest.springrest.service.CreditService;

@RestController
public class CreditCardController {

	@Autowired
	CreditService creditService;

	@GetMapping("/creditcard/{cardNumber}")
	public CreditCard getValidated(@PathVariable String cardNumber) {
		return this.creditService.validateCard(cardNumber);
	}

}
