package com.spring.jdbc.dao;

import com.spring.jdbc.model.Product;

public interface ProductDao {
	public String insert(Product product);

	public String update(Product product);

	public String delete(int id);
}
