package com.IJM.mapper;

import java.util.ArrayList;
import java.util.List;

import com.IJM.dto.CategoryDto;
import com.IJM.model.Category;

public class CategoryMapper {
	
	public static CategoryDto EntityToDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setName(category.getName());
		categoryDto.setId(category.getId());
		if(category.getParent()!=null)
		{
			categoryDto.setParent_id(category.getParent().getId());
		}
		return categoryDto;
	}

	public static Category DtoToEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());
		category.setId((categoryDto.getId()));
		if(categoryDto.getParent_id()!=null)
		{
			//category.setParent(DtoToEntity(categoryDto.getParent()));
			Category parent = new Category();
			parent.setId((categoryDto.getParent_id()));
			category.setParent(parent);
		}
		return category;
	}

	public static List<CategoryDto> EntityListToDtoList(List<Category> categories){
		
		List<CategoryDto> categoriesDto = new ArrayList<CategoryDto>();
		for (Category category : categories) {
			CategoryDto categoryDto = CategoryMapper.EntityToDto(category);
			categoriesDto.add(categoryDto);
		}
		return categoriesDto;
	}
}
