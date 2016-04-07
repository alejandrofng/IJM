package com.IJM.dao;

import java.util.List;

import com.IJM.model.Category;

public interface CategoryDao {

	public void save(Category category);

	public void delete(Category category);

	public List<Category> findAll();

	public Category findById(int id);

	public Category findByParentAndName(int id_Parent, String name);
	
	public void update(Category category);
}
