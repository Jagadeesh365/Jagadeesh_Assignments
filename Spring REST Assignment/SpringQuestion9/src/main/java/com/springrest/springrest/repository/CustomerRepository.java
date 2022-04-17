package com.springrest.springrest.repository;

import org.springframework.data.repository.CrudRepository;

import com.springrest.springrest.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
