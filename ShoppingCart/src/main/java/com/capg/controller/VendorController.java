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
import com.capg.entity.Vendor;
import com.capg.exception.ResourceNotFoundException;
import com.capg.service.VendorServiceImpl;

@RestController
@RequestMapping("/vendors")
public class VendorController {

	@Autowired
	private VendorServiceImpl service;

	@PostMapping("/addvendor")
	public ResponseEntity<?> addVendor(@RequestBody Vendor vendor) {
		return ResponseEntity.ok(service.addVendor(vendor));
	}

	@GetMapping("/getall")
	private List<Vendor> getAllOrders() {
		return service.getAllVendors();
	}

	@GetMapping("/vendorid/{vendorId}")
	public ResponseEntity<Vendor> getVendorById(@PathVariable("vendorId") Long vendorId)
			throws ResourceNotFoundException {
		Vendor vendor = service.getVendorById(vendorId);

		return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);

	}

	@PutMapping("/update")
	public Vendor updateVendor(@RequestBody Vendor vendor) throws ResourceNotFoundException {
		service.updateVendor(vendor);
		return vendor;

	}

	@GetMapping(path = "/getMenuByVendorId/{vendorId}")
	public List<Product> getMenuByVendorId(@PathVariable("vendorId") long vendorId) throws ResourceNotFoundException {
		return service.getMenuByVendorId(vendorId);
	}
	
	@DeleteMapping("/delete/{vendorId}")
	public void deleteVendorById(@PathVariable("vendorId") Long vendorId) throws ResourceNotFoundException {
	
		service.deleteVendorById(vendorId);

}
}













