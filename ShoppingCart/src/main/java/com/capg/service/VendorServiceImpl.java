package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Coupon;
import com.capg.entity.Product;
import com.capg.entity.Vendor;
import com.capg.exception.ResourceNotFoundException;
import com.capg.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	VendorRepository response;

	@Override
	public Vendor addVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return response.save(vendor);
	}

	@Override
	public List<Vendor> getAllVendors() {
		List<Vendor> list = new ArrayList<Vendor>();
		response.findAll().forEach(vendor1 -> list.add(vendor1));
		return list;
	}

	@Override
	public Vendor getVendorById(Long vendorId) throws ResourceNotFoundException {
		if (response.findById(vendorId).isPresent()) {
			Vendor vendor = response.findById(vendorId).get();
			return vendor;
		} else {
			throw new ResourceNotFoundException("record with " + vendorId + "  doesnot exist");

		}

	}

	@Override
	public Vendor updateVendor(Vendor vendor) throws ResourceNotFoundException {
		if (response.findById(vendor.getVendorId()).isPresent()) {
			return response.save(vendor);
		} else {
			throw new ResourceNotFoundException("vendor with id: " + vendor + "doesnt exsit");
		}
	}

	@Override
	public List<Product> getMenuByVendorId(long vendorId) throws ResourceNotFoundException {
			if(response.existsById(vendorId)) {
			Vendor vendor = response.findById(vendorId).get();
			List<Product> product = vendor.getProduct();
			if(product.isEmpty())
			{
				throw new ResourceNotFoundException("Vendor doesn't have any product");
			}
			return product;
			}
			throw new ResourceNotFoundException("Invalid Vendor ID") ;
			
		}

	@Override
	public void deleteVendorById(Long vendorId) throws ResourceNotFoundException {
		if (response.findById(vendorId).isPresent()) {
			response.deleteById(vendorId);
		}
		else {
		throw new ResourceNotFoundException("Vendor with Id: " + vendorId + " doesn't exist!!");
		}
		
	}
	}












