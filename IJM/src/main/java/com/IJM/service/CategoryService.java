package com.IJM.service;

import java.util.List;

import com.IJM.model.Category;


public interface CategoryService {
	
	public void saveCategory(Category  category);
	
	void updateCategory(Category category);
	
	public void deleteCategory(long code);

	public List<Category> findAllCategories();
	
	public Category findCategoryByCode (long code);
	
	public boolean isCategoryNameAlreadyExists (Category category);
	
	public boolean isCategoryExists(long code);
}
