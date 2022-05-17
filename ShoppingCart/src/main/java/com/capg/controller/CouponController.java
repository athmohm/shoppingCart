package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.entity.Coupon;
import com.capg.exception.ResourceNotFoundException;
import com.capg.service.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	private CouponService service;

	@PostMapping("/addcoupon")
	public ResponseEntity<?> addCoupon(@RequestBody Coupon coupon) {
		return ResponseEntity.ok(service.addCoupon(coupon));
	}

	@GetMapping("/getcoupon")
	private List<Coupon> getAllCoupon() {
		return service.getAllCoupon();
	}

	@PutMapping("/update")
	public Coupon updateCoupon(@RequestBody Coupon coupon) throws ResourceNotFoundException {
		service.updateCoupon(coupon);
		return coupon;
	}
	
	@DeleteMapping("/delete/{couponId}")
	public void deleteCouponById(@PathVariable("couponId") Long couponId) throws ResourceNotFoundException {
		
		service.deleteCouponById(couponId);
	}
	
	
	
	
}