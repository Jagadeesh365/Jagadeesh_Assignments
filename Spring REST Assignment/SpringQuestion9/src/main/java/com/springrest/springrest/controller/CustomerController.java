package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.model.Customer;
import com.springrest.springrest.services.CustomerService;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping()
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer Customer) {
		return new ResponseEntity<Customer>(customerService.saveCustomer(Customer), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long CustomerId) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(CustomerId), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer Customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(Customer, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {

		// delete Customer from DB
		customerService.deleteCustomer(id);

		return new ResponseEntity<String>("Customer deleted successfully!.", HttpStatus.OK);
	}
}
