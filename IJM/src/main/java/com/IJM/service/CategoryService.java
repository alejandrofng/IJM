package com.IJM.service;

import java.util.List;

import com.IJM.dto.CategoryDto;

public interface CategoryService {
	public void saveCategory(CategoryDto  categoryDto);
	
	void updateCategory(CategoryDto categoryDto);
	
	public void deleteCategory(String code);

	public List<CategoryDto> findAllCategoriesDto();
	
	public CategoryDto findCategoryDtoByCode (String code);
	
	public boolean isCategoryNameAlreadyExists (CategoryDto categoryDto);
	
	public boolean isCategoryExists(String code);
}
