package com.capg.service;

import java.util.List;

import com.capg.entity.Product;
import com.capg.entity.Vendor;
import com.capg.exception.ResourceNotFoundException;

public interface VendorService {

	public Vendor addVendor(Vendor vendor);

	public List<Vendor> getAllVendors() throws ResourceNotFoundException;

	public Vendor getVendorById(Long vendorId) throws ResourceNotFoundException;

	public Vendor updateVendor(Vendor vendor) throws ResourceNotFoundException;
	
	void deleteVendorById(Long vendorId) throws ResourceNotFoundException;
	
	public List<Product> getMenuByVendorId(long vendorId) throws ResourceNotFoundException;

}