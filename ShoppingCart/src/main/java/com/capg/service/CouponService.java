package com.capg.service;

import java.util.List;
import com.capg.entity.Coupon;

import com.capg.exception.ResourceNotFoundException;

public interface CouponService {

	Coupon addCoupon(Coupon coupon);

	List<Coupon> getAllCoupon();

	Coupon updateCoupon(Coupon coupon) throws ResourceNotFoundException;
	
	void deleteCouponById(Long couponId) throws ResourceNotFoundException;
	


}