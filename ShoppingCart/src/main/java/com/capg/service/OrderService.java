package com.capg.service;

import java.util.List;

import com.capg.entity.Order;
import com.capg.exception.ResourceNotFoundException;

public interface OrderService {

	Order addOrder(Order order);

	public List<Order> getAllOrders() throws ResourceNotFoundException;

	Order getOrderById(Long orderId) throws ResourceNotFoundException;

	Order updateOrder(Order order) throws ResourceNotFoundException;

	void deleteOrderById(Long orderId) throws ResourceNotFoundException;

}