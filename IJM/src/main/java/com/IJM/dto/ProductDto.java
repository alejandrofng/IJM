package com.IJM.dto;

public class ProductDto {
	
	private String code;
	
	private String name;
	
	private String description;
	
	private CategoryDto categoryDto;
	
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
	
	public CategoryDto getCategoryDto() {
		return categoryDto;
	}
	
	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}

	public UnitDto getUnitDto() {
		return unitDto;
	}

	public void setUnitDto(UnitDto unitDto) {
		this.unitDto = unitDto;
	}
	
}
