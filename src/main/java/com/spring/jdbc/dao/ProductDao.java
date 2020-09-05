package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.model.Product;

public interface ProductDao {
	public String insert(Product product);

	public String update(Product product);

	public String delete(int id);

	public Product getProduct(int id);
	
	public List<Product> getAllProduct();
}
