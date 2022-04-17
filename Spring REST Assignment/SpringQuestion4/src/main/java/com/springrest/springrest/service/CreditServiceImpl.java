package com.springrest.springrest.service;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entity.CreditCard;

@Service
public class CreditServiceImpl implements CreditService {

	@Override
	public CreditCard validateCard(String cardNumber) {

		CreditCard creditCard = null;
		long cardNum = Long.parseLong(cardNumber.substring(0, 6));
		long enRoute = Long.parseLong(cardNumber.substring(0, 4));
		long jcb = Long.parseLong(cardNumber.substring(0, 4));

		if (cardNumber.length() == 16) {
			if (cardNum >= 601100 && cardNum <= 601109) {

				long cardn = Long.parseLong(cardNumber);
				CreditCard creditCard2 = new CreditCard(cardn, "Valid Card", "American Express");
				creditCard = creditCard2;
				return creditCard;

			}else if((cardNum >= 510000 && cardNum <= 559999) || ((cardNum >= 222100 && cardNum <= 272099))) {
				
				long cardn = Long.parseLong(cardNumber);
				CreditCard creditCard2 = new CreditCard(cardn, "Valid Card", "MasterCard");
				creditCard = creditCard2;
				return creditCard;
				
			}

		} else if (cardNumber.length() == 15 && (enRoute == 2014 || enRoute == 2149)) {

			long cardn = Long.parseLong(cardNumber);
			CreditCard creditCard2 = new CreditCard(cardn, "Valid Card", "enRoute");
			creditCard = creditCard2;
			return creditCard;

		} else if ((cardNumber.length() >= 15 && cardNumber.length() <= 19) && (jcb >= 3528 && jcb <= 3589)) {

			long cardn = Long.parseLong(cardNumber);
			CreditCard creditCard2 = new CreditCard(cardn, "Valid Card", "JCB");
			creditCard = creditCard2;
			return creditCard;

		} else if ((cardNumber.length() > 0 && cardNumber.length() <= 19) && cardNumber.charAt(0) == 4) {

			CreditCard creditCard2 = new CreditCard(Long.parseLong(cardNumber), "Valid Card", "Visa");
			creditCard = creditCard2;
			return creditCard;

		}

		CreditCard creditCard2 = new CreditCard(Long.parseLong(cardNumber), "Invalid Card", "None");
		creditCard = creditCard2;
		return creditCard;
	}

}
