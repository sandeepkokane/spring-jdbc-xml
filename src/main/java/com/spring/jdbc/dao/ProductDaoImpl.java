package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.model.Product;

public class ProductDaoImpl implements ProductDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String insert(Product product) {
		String query = "insert into product(name,price) values(?,?)";
		int insert = this.jdbcTemplate.update(query ,product.getName(),product.getPrice());
		if(insert>0)
			return insert+" Rows inserted";
		else
			return insert+" Rows inserted";
		
	}
	

}
