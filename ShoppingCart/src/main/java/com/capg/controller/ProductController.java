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

import com.capg.entity.Product;
import com.capg.exception.ResourceNotFoundException;
import com.capg.service.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		return ResponseEntity.ok(service.addProduct(product));
	}

	@GetMapping("/getallProduct")
	private List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/Product/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId)
			throws ResourceNotFoundException {
		Product product = service.getProductById(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product) throws ResourceNotFoundException {
		service.updateProduct(product);
		return product;
	}
	
	@DeleteMapping("/delete/{productId}")
	public void deleteProductById(@PathVariable("productId") Long productId) throws ResourceNotFoundException {
	
		service.deleteProductById(productId);
}
}

















