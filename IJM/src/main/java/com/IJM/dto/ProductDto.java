package com.IJM.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductDto {
	
	private String code;
	
	private String name;
	
	private String description;
	
	@JsonIgnore
	private CategoryDto categoryDto;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryDto getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}

	
}
