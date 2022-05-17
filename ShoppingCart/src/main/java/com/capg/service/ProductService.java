package com.capg.service;

import java.util.List;

import com.capg.entity.Product;
import com.capg.exception.ResourceNotFoundException;

public interface ProductService {

	public Product addProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductById(Long productId) throws ResourceNotFoundException;

	public void updateProduct(Product product) throws ResourceNotFoundException;
	
	void deleteProductById(Long productId) throws ResourceNotFoundException;

}