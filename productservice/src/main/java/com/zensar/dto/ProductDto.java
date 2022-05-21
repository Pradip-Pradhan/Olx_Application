package com.zensar.dto;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private int productId;
	private String productName;
	private String discription;
	private Double price;
	private String couponCode;
}
