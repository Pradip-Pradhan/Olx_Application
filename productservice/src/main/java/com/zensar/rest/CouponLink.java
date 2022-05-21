package com.zensar.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.dto.CouponDto;

@FeignClient("GATEWAY-SERVICE")
//@LoadBalancerClient("COUPON-SERVICE")
public interface CouponLink {

	@GetMapping("/couponservice/{couponCode}")
	CouponDto getCoupon(@PathVariable String couponCode);
}
