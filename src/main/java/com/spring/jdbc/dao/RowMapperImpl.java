package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.model.Product;

public class RowMapperImpl implements RowMapper<Product>{

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt(1));
		product.setName(rs.getString(2));
		product.setPrice(rs.getInt(3));
		return product;
	}

}
