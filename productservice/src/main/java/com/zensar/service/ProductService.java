package com.zensar.service;

import java.util.List;

import com.zensar.dto.ProductDto;

public interface ProductService {

	ProductDto createProduct(ProductDto product);
	ProductDto updateProduct(int productId, ProductDto product);
	List<ProductDto> readAllProduct();
	String deleteProductById(int productId);
	String deleteAllProduct();
}
