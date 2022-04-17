package com.springrest.springrest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springrest.springrest.model.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}
