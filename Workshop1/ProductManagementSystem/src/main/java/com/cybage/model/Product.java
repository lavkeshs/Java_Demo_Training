package com.cybage.model;

public class Product {
	private int id;
	private String name;
	private double price;
	
	public Product() {
		super();
	}
	
	public Product(int id, String name, double price) {
		super();
		this.id=id;
		this.name = name;
		this.price = price;
	}
	public Product(String name, double price) {
		super();
		
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	

}
