package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.capg.entity.Order;
import com.capg.exception.ResourceNotFoundException;
import com.capg.service.OrderServiceImpl;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderServiceImpl service;

	@PostMapping("/addorder")
	public ResponseEntity<?> addOrder(@RequestBody Order order) {
		return ResponseEntity.ok(service.addOrder(order));
	}

	@GetMapping("/order")
	private List<Order> getAllOrders() throws ResourceNotFoundException {
		return service.getAllOrders();
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderId") Long orderId)
			throws ResourceNotFoundException {

		Order order = service.getOrderById(orderId);

		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@PutMapping("/update")
	public Order updateOrder(@RequestBody Order order) throws ResourceNotFoundException {
		service.updateOrder(order);
		return order;
	}

	@DeleteMapping("/delete/{orderId}")
	public void deleteOrderById(@PathVariable("orderId") Long orderId) throws ResourceNotFoundException {

		service.deleteOrderById(orderId);

	}

}