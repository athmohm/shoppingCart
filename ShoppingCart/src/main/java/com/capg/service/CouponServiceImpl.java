package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.entity.Coupon;
import com.capg.exception.ResourceNotFoundException;
import com.capg.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	CouponRepository response;

	@Override
	public Coupon addCoupon(Coupon coupon) {
		return response.save(coupon);
	}

	@Override
	public List<Coupon> getAllCoupon() {
		List<Coupon> list = new ArrayList<Coupon>();
		response.findAll().forEach(coupon1 -> list.add(coupon1));
		return list;
	}

	@Override
	public Coupon updateCoupon(Coupon coupon) throws ResourceNotFoundException {
		if (response.findById(coupon.getCouponId()).isPresent()) {
			return response.save(coupon);
		} else {
			throw new ResourceNotFoundException("Coupon with Id:" + coupon + "doesn't exist!!");
		}
	}

	@Override
	public void deleteCouponById(Long couponId) throws ResourceNotFoundException {
		if (response.findById(couponId).isPresent()) {
			response.deleteById(couponId);
		}
	}
	
	
	
	
	
	



}