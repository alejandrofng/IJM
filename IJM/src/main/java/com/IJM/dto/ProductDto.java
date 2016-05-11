package com.IJM.dto;


public class ProductDto {
	
	private String code;
	
	private String name;
	
	private String description;
	
	private CategoryDto category;
	
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
	
	public CategoryDto getCategory() {
		return category;
	}
	
	public void setCategory(CategoryDto categoryDto) {
		this.category = categoryDto;
	}

	public UnitDto getUnitDto() {
		return unitDto;
	}

	public void setUnitDto(UnitDto unitDto) {
		this.unitDto = unitDto;
	}
		
}