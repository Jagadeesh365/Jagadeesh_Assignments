package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.exception.ResourceNotFoundException;
import com.springrest.springrest.model.Customer;
import com.springrest.springrest.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
	}

	@Override
	public void deleteCustomer(long id) {

		customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
		customerRepository.deleteById(id);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		// we need to check whether Customer with given id is exist in DB or not
		Customer existingCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));

		existingCustomer.setCustomerName(customer.getCustomerName());
		existingCustomer.setAccountType(customer.getAccountType());
		existingCustomer.setPhoneNumber(customer.getPhoneNumber());
		existingCustomer.setCustomerAddress(customer.getCustomerAddress());
		// save existing Customer to DB
		customerRepository.save(existingCustomer);
		return existingCustomer;
	}
}
