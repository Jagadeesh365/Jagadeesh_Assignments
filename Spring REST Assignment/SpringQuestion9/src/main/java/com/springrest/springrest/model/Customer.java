package com.springrest.springrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	
	@Column(name = "customer_name", nullable = false)
	private String customerName;
	
	@Column(name = "account_type", nullable = false)
	private String accountType;
	
	@Column(name = "phone_number")
	private long phoneNumber;
	
	@Column(name = "customer_address")
	private String customerAddress;
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer(long customerId, String customerName, String accountType, long phoneNumber,
			String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.accountType = accountType;
		this.phoneNumber = phoneNumber;
		this.customerAddress = customerAddress;
	}



	public long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public long getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getCustomerAddress() {
		return customerAddress;
	}



	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	
	
	

}
