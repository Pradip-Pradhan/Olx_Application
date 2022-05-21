package com.zensar.controller;

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

import com.zensar.dto.CouponDto;
import com.zensar.service.CouponService;

@RestController
@RequestMapping("/couponservice")
public class CouponServiceController {

	@Autowired
	private CouponService couponService;
	
	
	@PostMapping
	public ResponseEntity<CouponDto> createProduct(@RequestBody CouponDto couponDto){
		System.out.println("------------------------------------");
		CouponDto createdcoupon = couponService.createProduct(couponDto);
		return new ResponseEntity<CouponDto>(createdcoupon,HttpStatus.CREATED);
	}
	
	@PutMapping("/{couponId}")
	public CouponDto updateProduct(@PathVariable int couponId, @RequestBody CouponDto couponDto) {
		return couponService.updateProduct(couponId, couponDto);
	}
	
	@GetMapping
	public List<CouponDto> getAllCoupon() {
		return couponService.readAllCoupon();
	}
	
	@GetMapping("/{couponCode}")
	public CouponDto getCouponByCode(@PathVariable String couponCode) {
		System.out.println("instance 1");
		return couponService.getCouponByCode(couponCode);
	}
	
	@DeleteMapping("/{couponId}")
	public String deleteCouponById(@PathVariable int couponId) {
		return couponService.deleteCouponById(couponId);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAllCoupon() {
		couponService.deleteAllCoupon();
		return new ResponseEntity<String>("deleted", HttpStatus.CONFLICT);
	}
}
