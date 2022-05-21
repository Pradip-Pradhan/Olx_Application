package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;
import com.zensar.repository.CouponServiceRepository;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponServiceRepository couponServiceRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CouponDto createProduct(CouponDto coupon) {
		System.out.println("------------------------------------");
		Coupon newCoupon = modelMapper.map(coupon, Coupon.class);
		Coupon saveCoupon=couponServiceRepository.save(newCoupon);
		CouponDto newOne = modelMapper.map(saveCoupon, CouponDto.class);
		return newOne;
	}

	
	public CouponDto getCouponById(int couponId) {
		Optional<Coupon> couponReponse=couponServiceRepository.findById(couponId);
		Coupon coupon2=null;
		if(couponReponse.isPresent()) {
			coupon2=couponReponse.get();
			return modelMapper.map(coupon2, CouponDto.class);
		}else {
			return null;
		}
	}
	@Override
	public CouponDto getCouponByCode(String couponCode) {
		
		Coupon coupon = couponServiceRepository.findByCouponCode(couponCode);
		return modelMapper.map(coupon, CouponDto.class);
	}
	
	
	@Override
	public CouponDto updateProduct(int couponId, CouponDto coupon) {
		CouponDto couponReponse=getCouponById(couponId);
		Coupon coupon2=modelMapper.map(couponReponse, Coupon.class);
		if(coupon2!=null) {
			
			if(coupon.getCouponCode()==null) {
				coupon2.setCouponCode(coupon2.getCouponCode());
			}else {
				coupon2.setCouponCode(coupon.getCouponCode());
			}
			
			if(coupon.getDiscount()==null) {
				coupon2.setDiscount(coupon2.getDiscount());
			}else {
				coupon2.setDiscount(coupon.getDiscount());
			}
			
			if(coupon.getExpDate()==null) {
				coupon2.setExpDate(coupon2.getExpDate());
			}else {
				coupon2.setExpDate(coupon.getExpDate());
			}
			Coupon updatedCoupon=couponServiceRepository.save(coupon2);
			return modelMapper.map(updatedCoupon, CouponDto.class);
		}else
		{
			return null;
		}
	}

	@Override
	public List<CouponDto> readAllCoupon() {
		List<Coupon> coupons = couponServiceRepository.findAll();
		List<CouponDto> dtos=new ArrayList<CouponDto>();
		
		for(Coupon coupon:coupons) {
			CouponDto mapToResponse=modelMapper.map(coupon, CouponDto.class);
			dtos.add(mapToResponse);
		}
		return dtos;
	}

	@Override
	public String deleteCouponById(int couponId) {
		couponServiceRepository.deleteById(couponId);
		return "deleted coupon with couponId "+couponId;
	}

	@Override
	public String deleteAllCoupon() {
		couponServiceRepository.deleteAll();
		return "deleted All coupons";
	}


	

}
