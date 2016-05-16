package com.IJM.dao;

import java.util.List;

import com.IJM.model.Product;

public interface ProductDao {

	public void save(Product product);

	public void delete(Product product);

	public List<Product> findAll();

	public Product findById(Long id);
	
	public Product findByCode(String code);

	public void update(Product product);
}