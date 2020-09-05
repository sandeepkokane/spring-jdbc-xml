package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

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
		int insert = this.jdbcTemplate.update(query, product.getName(), product.getPrice());
		if (insert > 0)
			return insert + " Rows inserted";
		else
			return insert + " Rows inserted";

	}

	public String update(Product product) {
		String query = "update product set name=?, price=? where id=?";
		int update = this.jdbcTemplate.update(query, product.getName(), product.getPrice(), product.getId());
		if (update > 0)
			return update + " Rows updated";
		else
			return update + " Rows updated";
	}

	public String delete(int id) {
		String query = "delete from product where id = ?";
		int delete = this.jdbcTemplate.update(query, id);
		if (delete > 0)
			return delete + " Rows deleted";
		else
			return delete + " Rows deleted";
	}

	public Product getProduct(int id) {
		String query = "select * from product where id = ?";
		RowMapper<Product> rowMapper = new RowMapperImpl();
		Product product = this.jdbcTemplate.queryForObject(query, rowMapper, id);

		return product;

	}

	public List<Product> getAllProduct() {
		String query = "select * from product";
		List<Product> list = this.jdbcTemplate.query(query, new RowMapperImpl());
		return list;
	}

}
