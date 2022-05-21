package com.zensar.service;

import java.util.List;

import com.zensar.dto.CouponDto;

public interface CouponService {

	CouponDto createProduct(CouponDto coupon);
	CouponDto updateProduct(int couponId, CouponDto coupon);
	List<CouponDto> readAllCoupon();
	String deleteCouponById(int couponId);
	String deleteAllCoupon();
	CouponDto getCouponByCode(String couponCode);
}
