package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Order;
import com.capg.entity.OrderDetails;
import com.capg.exception.ResourceNotFoundException;
import com.capg.service.OrderDetailsService;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {
	@Autowired
	private OrderDetailsService service;
	
	@PostMapping("/addOrderDetails")
	public ResponseEntity<?> addOrderDetails(@RequestBody OrderDetails orderDetails) {
		return ResponseEntity.ok(service.addOrderDetails(orderDetails));
	}
	
	@GetMapping(path = "/getOrderByOrderDetailsById/{orderDetailsId}")
	public List<Order> getOrderByOrderDetailsById(@PathVariable("orderDetailsId") long orderDetailsId) throws ResourceNotFoundException{
		return service.getOrderByOrderDetailsById(orderDetailsId);
		
	}
	
	@GetMapping("/orderDetailsId/{orderDetailsId}")
	public ResponseEntity<OrderDetails> getOrderDetailsId(@PathVariable("orderDetailsId") Long orderDetailsId)throws ResourceNotFoundException {
	
		OrderDetails orderDetails = service.getOrderDetailsById(orderDetailsId);
		return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);
		
		
	}
	
	@PutMapping("/update")
	public OrderDetails updateOrderDetails(@RequestBody OrderDetails orderDetails) throws ResourceNotFoundException {
		service.updateOrderDetails(orderDetails);
		return orderDetails;
	
	
	}
}







