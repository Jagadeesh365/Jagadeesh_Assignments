package com.springrest.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.model.Order;
import com.springrest.springrest.repository.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	/* A user can place an order */
	@PutMapping("/addOrders")
	public String saveAllBook(@RequestBody Order order) {

		orderRepository.save(order);
		return "Order Added Successfully";
	}

	/* A user can update an order */
	@PostMapping("/addOrder")
	public String saveBook(@RequestBody Order order) {

		orderRepository.insert(order);
		return "Order Added Successfully";
	}

	/* A user can view specific order */
	@GetMapping("/find/{id}")
	public Optional<Order> getOrder(@PathVariable int id) {
		return orderRepository.findById(id);

	}

	/* A user can view all the orders */
	@GetMapping("/findAll")
	public List<Order> getOrders() {

		return orderRepository.findAll();
	}

	/* A user can delete a specific order */
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		orderRepository.deleteById(id);

		return "Order Cancelled Successfully";
	}
}
