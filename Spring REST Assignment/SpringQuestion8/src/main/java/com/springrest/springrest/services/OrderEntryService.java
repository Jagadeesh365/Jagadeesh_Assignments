package com.springrest.springrest.services;

import com.springrest.springrest.model.Order;

public interface OrderEntryService {
	public Order[] getOrders();

	public Order getOrder(int id);

	public void submitOrder(Order order);

	public void updateOrder(Order order);

	public void deleteOrder(int id);

	public void cancelOrder(int id);
}
