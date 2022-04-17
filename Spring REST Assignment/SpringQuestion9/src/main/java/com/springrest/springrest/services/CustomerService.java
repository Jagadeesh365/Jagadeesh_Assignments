package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.model.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);

	Customer getCustomerById(long id);

	void deleteCustomer(long id);

	List<Customer> getAllCustomers();

	Customer updateCustomer(Customer Customer, long id);
}
