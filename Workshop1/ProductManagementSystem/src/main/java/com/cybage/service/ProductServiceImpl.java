package com.cybage.service;

import java.util.List;
import java.util.Scanner;

import com.cybage.dao.ProductDao;
import com.cybage.dao.ProductDaoImpl;
import com.cybage.model.Product;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao;
	
	public ProductServiceImpl() {
		productDao=new ProductDaoImpl();
	}
	
	public int addProduct() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Product Name: ");
		String nm=sc.next();
		System.out.println("Enter Price:");
		double price=sc.nextDouble();
		Product p=new Product(nm,price);
		return productDao.save(p);
	}

	public List<Product> displayAll() {
		return productDao.findAll();
		
	}
	
	public boolean deleteById(int id) {
		return productDao.deleteById(id);
	}
	
	public Product getById(int id) {
		return productDao.findById(id);
	}

	public void closeConnection() {
		productDao.closeConnection();
		
	}
}
