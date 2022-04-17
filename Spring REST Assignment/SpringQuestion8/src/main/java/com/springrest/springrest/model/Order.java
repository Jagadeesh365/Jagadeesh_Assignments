package com.springrest.springrest.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "OrderDetails")
public class Order {
	
	private int id;
	private float total;
	private Date date;
	private Customer customer;

	public void addLineItem(LineItem lineItem) {

	}

	public void removeLineItem(LineItem lineItem) {

	}
	public LineItem[] getLineItems() {
		return null;
		
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, float total, Date date, Customer customer) {
		super();
		this.id = id;
		this.total = total;
		this.date = date;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
