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
import org.springframework.web.client.RestTemplate;

import com.zensar.dto.CouponDto;
import com.zensar.dto.ProductDto;
import com.zensar.service.ProductService;

@RestController
@RequestMapping("/productservice")
public class ProductServiceController {

	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
		ProductDto createdProduct = productService.createProduct(productDto);
		return new ResponseEntity<ProductDto>(createdProduct,HttpStatus.CREATED);
	}
	
	@PutMapping("/{productId}")
	public ProductDto updateProduct(@PathVariable int productId, @RequestBody ProductDto productDto) {
		return productService.updateProduct(productId, productDto);
	}
	
	@GetMapping
	public List<ProductDto> getAllProduct() {
		return productService.readAllProduct();
	}
	
	@DeleteMapping("/{productId}")
	public String deleteProductById(@PathVariable int productId) {
		return productService.deleteProductById(productId);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAllProduct() {
		productService.deleteAllProduct();
		return new ResponseEntity<String>("deleted", HttpStatus.CONFLICT);
	}
}
