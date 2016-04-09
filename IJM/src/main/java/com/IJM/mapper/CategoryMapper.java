package com.IJM.mapper;

import java.util.ArrayList;
import java.util.List;

import com.IJM.dto.CategoryDto;
import com.IJM.model.Category;

public class CategoryMapper {
	
	public static CategoryDto EntityToDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setName(category.getName());
		categoryDto.setCode(category.getId());
		return categoryDto;
	}

	public static Category DtoToEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());
		category.setId((categoryDto.getCode()));
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
