package com.zensar.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.spring.beans.Product;
import com.zensar.spring.repository.ProductRepository;


public class ProductServiceImpl1 implements ProductService {

	
	private ProductRepository repositoryImpl;

	/*
	 * public ProductServiceImpl1(ProductRepository repository) { System.out.
	 * println("inside public ProductServiceImpl1(ProductRepository repository) !!!"
	 * ); this.repositoryImpl=repository; }
	 */
	public String insertProduct(Product product) {

		return repositoryImpl.insertProduct(product);
	}
	
	public List<Product> getAllProductsRowMapper(){
		return repositoryImpl.getAllProductsRowMapper();
	}
	
	public String updateIdWithRespectToId(int newId ,int oldId) {
		return repositoryImpl.updateIdWithRespectToId(newId, oldId);
	}
	public String updateNameWithRespectToId(String newName ,int oldId) {
		return repositoryImpl.updateNameWithRespectToId(newName, oldId);
	}
	public String updatePriceWithRespectToId(int newCost ,int oldId) {
		return repositoryImpl.updatePriceWithRespectToId(newCost, oldId);
	}
	
	public String deleteInfo(int deleteId) {
		return repositoryImpl.deleteInfo(deleteId);
	}
	
	public String dropTable() {
		return repositoryImpl.dropTable();
	}

	public ProductRepository getRepositoryImpl() {
		return repositoryImpl;
	}

	public void setRepositoryImpl(ProductRepository repositoryImpl) {
		System.out.println("inside public void setRepositoryImpl(ProductRepository repositoryImpl !!)");
		this.repositoryImpl = repositoryImpl;
	}

	@PostConstruct
	public void myInit() {
		System.out.println("inside myInit() !!!");
	}

	@PreDestroy
	public void myDestroy() {
		System.out.println(" inside myDestroy()");
	}

}
