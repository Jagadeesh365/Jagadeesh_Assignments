package com.springrest.springrest.service;

import com.springrest.springrest.entity.CreditCard;

public interface CreditService {
	public CreditCard validateCard(String cardNumber);
}
