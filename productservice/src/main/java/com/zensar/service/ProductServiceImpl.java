package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zensar.dto.CouponDto;
import com.zensar.dto.ProductDto;
import com.zensar.entity.Product;
import com.zensar.repository.ProductServiceRepository;
import com.zensar.rest.CouponLink;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductServiceRepository productServiceRepository;
	
	@Autowired
	private ModelMapper modelMapper;

//	@Autowired
//	public RestTemplate restTemplate;
	
	@Autowired
	public CouponLink link;
	
	@Override
	public ProductDto createProduct(ProductDto product) {
		
		Product newProduct = modelMapper.map(product, Product.class);
		Product saveProduct=productServiceRepository.save(newProduct);
		Product save=null;
//		CouponDto couponDto = restTemplate.getForObject("http://localhost:5000/couponservice/"+saveProduct.getCouponCode(), CouponDto.class);
//		CouponDto couponDto = restTemplate.getForObject("http://COUPON-SERVICE/couponservice/"+saveProduct.getCouponCode(), CouponDto.class);
		CouponDto couponDto = link.getCoupon(saveProduct.getCouponCode());
		
		if(saveProduct.getPrice()>30000) {
			saveProduct.setPrice(saveProduct.getPrice()-couponDto.getDiscount());
			save=productServiceRepository.save(saveProduct);
		}
		ProductDto newOne = modelMapper.map(save, ProductDto.class);
		return newOne;
	}

	
	public ProductDto getProductById(int productId) {
		Optional<Product> productReponse=productServiceRepository.findById(productId);
		Product product2=null;
		if(productReponse.isPresent()) {
			product2=productReponse.get();
			return modelMapper.map(product2, ProductDto.class);
		}else {
			return null;
		}
	}
	
	
	@Override
	public ProductDto updateProduct(int productId, ProductDto product) {

		ProductDto productReponse=getProductById(productId);
		Product product2=modelMapper.map(productReponse, Product.class);
		if(product2!=null) {
			
			if(product.getProductName()==null) {
				product2.setProductName(product2.getProductName());
			}else {
				product2.setProductName(product.getProductName());
			}
			
			if(product.getDiscription()==null) {
				product2.setDiscription(product2.getDiscription());
			}else {
				product2.setDiscription(product.getDiscription());
			}
			
			if(product.getPrice()==null) {
				product2.setPrice(product2.getPrice());
			}else {
				product2.setPrice(product.getPrice());
			}
			
			
			Product updatedProduct=productServiceRepository.save(product2);
			return modelMapper.map(updatedProduct, ProductDto.class);
		}else
		{
			return null;
		}
	}

	@Override
	public List<ProductDto> readAllProduct() {
		List<Product> products = productServiceRepository.findAll();
		List<ProductDto> dtos=new ArrayList<ProductDto>();
		
		for(Product product:products) {
			ProductDto mapToResponse=modelMapper.map(product, ProductDto.class);
			dtos.add(mapToResponse);
		}
		return dtos;
	}

	@Override
	public String deleteProductById(int productId) {
		productServiceRepository.deleteById(productId);
		return "deleted product with productId "+productId;
	}

	@Override
	public String deleteAllProduct() {
		productServiceRepository.deleteAll();
		return "deleted All Products";
	}

}
