package com.zensar.spring.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {
	List<Product> product = new ArrayList<Product>();

	private JdbcTemplate template;

	public ProductRepositoryImpl1() {

	}

	public String insertProduct(Product product) {
		createTable();
		String sql = "insert into product values(" + product.getProductId() + ",'" + product.getProductName() + "',"
				+ product.getProductCost() + ");";
		template.execute(sql);
		return "Product inserted successfullyyyyy !!!";
	}
	
	
	
	

//	NamedParameterJdbcTemplate template1;
//
//	public ProductRepositoryImpl1(NamedParameterJdbcTemplate template1) {
//		this.template1 = template1;
//	}
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public void save(Product p) {
//		String query="insert into product values(:productId,:productName,:productCost);";
//		
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("productId", p.getProductId());
//		map.put("productName", p.getProductName());  
//		map.put("productCost", p.getProductCost());  
//		
//		template1.execute(query,map,new PreparedStatementCallback() {
//
//			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
//				 return ps.executeUpdate();
//			}
//		});
//	}
//	
//	
//	

	public List<Product> getAllProductsRowMapper() {
		return template.query("select * from product", new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setProductId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setProductCost(rs.getInt(3));
				return p;
			}

		});

	}

	public String updateIdWithRespectToId(int newId, int oldId) {
		String sql = "update product set productId=" + newId + " where productId=" + oldId + ";";
		template.execute(sql);
		return "updated";
	}

	public String updateNameWithRespectToId(String newName, int oldId) {
		String sql = "update product set productName=" + newName + " where productId=" + oldId + ";";
		template.execute(sql);
		return "updated";
	}

	public String updatePriceWithRespectToId(int newCost, int oldId) {
		String sql = "update product set productCost=" + newCost + " where productId=" + oldId + ";";
		template.execute(sql);
		return "updated";
	}

	public String deleteInfo(int deleteId) {
		String sql = "DELETE FROM product where productId=" + deleteId + ";";
		template.execute(sql);
		return "deleted row";
	}

	public String dropTable() {
		String sql = "drop table product;";
		template.execute(sql);
		return "table droped";
	}

	public void createTable() {
		template.execute("create table if not exists product (productId int ,productName varchar(50),productCost int)");
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
