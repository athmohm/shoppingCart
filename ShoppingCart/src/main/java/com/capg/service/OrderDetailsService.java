package com.capg.service;

import java.util.List;

import com.capg.entity.Order;
import com.capg.entity.OrderDetails;
import com.capg.entity.Product;
import com.capg.entity.Vendor;
import com.capg.exception.ResourceNotFoundException;

public interface OrderDetailsService {
	
	public OrderDetails addOrderDetails(OrderDetails orderDetails);
	
	public OrderDetails getOrderDetailsById(Long orderDetailsId) throws ResourceNotFoundException;
	
	public List<Order> getOrderByOrderDetailsById(long orderDetailsId) throws ResourceNotFoundException;
	
	public OrderDetails updateOrderDetails(OrderDetails orderDetails) throws ResourceNotFoundException;

}