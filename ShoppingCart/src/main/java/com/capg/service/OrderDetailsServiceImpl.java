package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Order;
import com.capg.entity.OrderDetails;
import com.capg.entity.Product;
import com.capg.entity.Vendor;
import com.capg.exception.ResourceNotFoundException;
import com.capg.repository.OrderDetailsRepository;
import com.capg.repository.VendorRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	OrderDetailsRepository response;

	@Override
	public List<Order> getOrderByOrderDetailsById(long orderDetailsId) throws ResourceNotFoundException {
		if (response.existsById(orderDetailsId)) {
			OrderDetails orderDetails = response.findById(orderDetailsId).get();

			List<Order> order = orderDetails.getOrder();
			
			if (order.isEmpty()) {
				throw new ResourceNotFoundException("order details doesn't have any order");
			}
			return order;
		}
		throw new ResourceNotFoundException("Inavlid order details  ID");

	}

	@Override
	public OrderDetails addOrderDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		return response.save(orderDetails);
	}

	@Override
	public OrderDetails getOrderDetailsById(Long orderDetailsId) throws ResourceNotFoundException {
		if (response.findById(orderDetailsId).isPresent()) {
			OrderDetails orderDetails = response.findById(orderDetailsId).get();
			return orderDetails;
		} else {
			throw new ResourceNotFoundException("record with " + orderDetailsId + "  doesnot exist");
	
		}
	}

	@Override
	public OrderDetails updateOrderDetails(OrderDetails orderDetails) throws ResourceNotFoundException {
		if (response.findById(orderDetails.getOrderDetailsId()).isPresent()) {
			return response.save(orderDetails);
		} else {
			throw new ResourceNotFoundException("orderDetails with id: " + orderDetails + "doesnt exsit");
		}
	}
}


















