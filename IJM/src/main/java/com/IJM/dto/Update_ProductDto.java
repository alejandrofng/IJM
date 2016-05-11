package com.IJM.dto;

import java.util.Set;

public class Update_ProductDto {
	
	private String code;
	
	private String name;
	
	private String description;
	
	private Set<CategoryDto> categories;
	
	private Set<String> imageUrl;
	
	private UnitDto unitDto;
	
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

	public UnitDto getUnitDto() {
		return unitDto;
	}

	public void setUnitDto(UnitDto unitDto) {
		this.unitDto = unitDto;
	}

	public Set<CategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryDto> categories) {
		this.categories = categories;
	}

	public Set<String> getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(Set<String> imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
