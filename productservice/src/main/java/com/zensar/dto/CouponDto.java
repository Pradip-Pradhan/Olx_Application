package com.zensar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto {

	private int couponId;
	private String couponCode;
	private Double discount;
	private String expDate;
}
