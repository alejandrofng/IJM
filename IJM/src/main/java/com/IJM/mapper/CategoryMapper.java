package com.IJM.mapper;

import java.util.ArrayList;
import java.util.List;

import com.IJM.dto.CategoryDto;
import com.IJM.model.Category;

public class CategoryMapper {
	
	public CategoryDto EntityToDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setName(category.getName());
		categoryDto.setId(category.getId());
		if(category.getParent()!=null)
		{
			categoryDto.setId_parent(category.getParent().getId());
		}
		return categoryDto;
	}

	public Category DtoToEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());
		if(categoryDto.getId()!=null)
			category.setId((categoryDto.getId()));
		if(categoryDto.getId_parent()!=null)
		{
			//category.setParent(DtoToEntity(categoryDto.getParent()));
			Category parent = new Category();
			parent.setId((categoryDto.getId_parent()));
			category.setParent(parent);
		}
		return category;
	}

	public List<CategoryDto> EntityListToDtoList(List<Category> categories){
		
		List<CategoryDto> categoriesDto = new ArrayList<CategoryDto>();
		for (Category category : categories) {
			CategoryDto categoryDto = this.EntityToDto(category);
			categoriesDto.add(categoryDto);
		}
		return categoriesDto;
	}
}
