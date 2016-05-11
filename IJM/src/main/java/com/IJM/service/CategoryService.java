package com.IJM.service;

import java.util.List;

import com.IJM.dto.CategoryDto;
import com.IJM.model.Category;

public interface CategoryService {
	
	public void saveCategory(CategoryDto  categoryDto);
	
	void updateCategory(CategoryDto categoryDto);
	
	public void deleteCategory(long code);

	public List<CategoryDto> findAllCategoriesDto();
	
	public CategoryDto findCategoryDtoByCode (long code);
	
	public boolean isCategoryNameAlreadyExists (CategoryDto categoryDto);
	
	public boolean isCategoryExists(long code);

	public List<Category> findAllCategories();
	
	
}
