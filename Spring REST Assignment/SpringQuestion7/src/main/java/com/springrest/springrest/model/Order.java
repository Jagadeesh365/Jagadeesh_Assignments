package com.springrest.springrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "Order")
public class Order {

	@Id
	private long orderID;
	private String itemName;
	private int deliveryDate;
	private double orderAmount;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(long orderID, String itemName, int deliveryDate, double orderAmount) {
		super();
		this.orderID = orderID;
		this.itemName = itemName;
		this.deliveryDate = deliveryDate;
		this.orderAmount = orderAmount;
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(int deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	
}
