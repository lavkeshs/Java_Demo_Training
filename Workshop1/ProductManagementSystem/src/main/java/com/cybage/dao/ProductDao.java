package com.cybage.dao;

import java.util.List;

import com.cybage.model.Product;

public interface ProductDao {
	
	int save(Product p);
	
	List<Product> findAll();
	
	boolean deleteById(int id);
	
	Product findById(int id);
	
	void closeConnection();
	
}
