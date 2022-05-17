package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Order;
import com.capg.exception.ResourceNotFoundException;
import com.capg.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository response;

	@Override
	public Order addOrder(Order order) {
		return response.save(order);
	}

	@Override
	public List<Order> getAllOrders() throws ResourceNotFoundException {
		List<Order> order = (List<Order>) response.findAll();
		if (order == null)
			throw new ResourceNotFoundException("Order not created");
		return order;
	}

	@Override
	public Order getOrderById(Long orderId) throws ResourceNotFoundException {

		if (response.findById(orderId).isPresent()) {
			Order order = response.findById(orderId).get();
			return order;
		} else {
			throw new ResourceNotFoundException("Order with Id: " + orderId + " doesn't exist!!");
		}
	}

	@Override
	public Order updateOrder(Order order) throws ResourceNotFoundException {
		if (response.findById(order.getOrderId()).isPresent()) {
			return response.save(order);
		}

		else {
			throw new ResourceNotFoundException("Order with Id: " + order + " doesn't exist!!");
		}
	}

	@Override
	public void deleteOrderById(Long orderId) throws ResourceNotFoundException {

		if (response.findById(orderId).isPresent()) {
			response.deleteById(orderId);
		} else {
			throw new ResourceNotFoundException("Order with Id: " + orderId + " doesn't exist!!");
		}
	}
}