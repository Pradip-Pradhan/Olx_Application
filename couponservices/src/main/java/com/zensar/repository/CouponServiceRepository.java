package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;

public interface CouponServiceRepository extends JpaRepository<Coupon, Integer> {

	Coupon findByCouponCode(String couponCode);
}
