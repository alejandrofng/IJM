package com.IJM.dto;

import java.util.Set;

public class ProductDto {
	
	private String code;
	
	private String name;
	
	private String description;
	
	private CategoryDto category;
	
	private UnitDto unit;
	
	private String price;
	
	private Set<ImageDto> images;
	
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

	public UnitDto getUnit() {
		return unit;
	}

	public void setUnit(UnitDto unit) {
		this.unit = unit;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Set<ImageDto> getImages() {
		return images;
	}

	public void setImages(Set<ImageDto> images) {
		this.images = images;
	}

}
