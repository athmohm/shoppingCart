package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Coupon;

import com.capg.entity.Product;
import com.capg.entity.Vendor;
import com.capg.exception.ResourceNotFoundException;
import com.capg.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository response;

	@Override
	public Product addProduct(Product product) {
		return response.save(product);

	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<Product>();
		response.findAll().forEach(order1 -> list.add(order1));
		return list;
	}

	@Override
	public Product getProductById(Long productId) throws ResourceNotFoundException {
		if (response.findById(productId).isPresent()) {
			Product product = response.findById(productId).get();
			return product;
		} else {
			throw new ResourceNotFoundException("Product with Id" + productId + "doesn't exist");
		}

	}

	public void updateProduct(Product product) throws ResourceNotFoundException {
		if (response.findById(product.getProductId()).isPresent()) {
			response.save(product);
		} else {
			throw new ResourceNotFoundException("Product with Id" + product + "doesn't exist");
		}

	}

	@Override
	public void deleteProductById(Long productId) throws ResourceNotFoundException {
		if (response.findById(productId).isPresent()) {
		response.deleteById(productId);
		}else {
			throw new ResourceNotFoundException("product with Id: " + productId + " doesn't exist!!");
			}
		
	}
}















