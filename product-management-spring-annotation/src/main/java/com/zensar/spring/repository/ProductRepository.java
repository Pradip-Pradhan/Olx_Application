package com.zensar.spring.repository;

import java.util.List;

import com.zensar.spring.beans.Product;

public interface ProductRepository {

	String insertProduct(Product product);
	List<Product> getAllProductsRowMapper();
	String updateIdWithRespectToId(int newId ,int oldId);
    String updateNameWithRespectToId(String newName ,int oldId);
	String updatePriceWithRespectToId(int newCost, int oldId);
	String deleteInfo(int deleteId);
	String dropTable();
}
