package com.springrest.springrest.entity;

public class CreditCard {

	private long cardNumber;
	private String isvalid;
	private String cardType;

	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCard(long cardNumber, String isvalid, String cardType) {
		super();
		this.cardNumber = cardNumber;
		this.isvalid = isvalid;
		this.cardType = cardType;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Override
	public String toString() {
		return "CreditCard [cardNumber=" + cardNumber + ", isvalid=" + isvalid + ", cardType=" + cardType + "]";
	}

}
