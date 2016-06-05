package com.IJM.dto;

import java.util.Set;

public class ProductDto {
	
	
	
	private String code;
	
	private String name;
	
	private String description;
	
	private CategoryDto category;
	
	private UnitDto unit;
	
	private String price_regular;
	
	private String price_discount;
	
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

	public String getPrice_regular() {
		return price_regular;
	}

	public void setPrice_regular(String price) {
		this.price_regular = price;
	}

	public Set<ImageDto> getImages() {
		return images;
	}

	public void setImages(Set<ImageDto> images) {
		this.images = images;
	}

	public String getPrice_discount() {
		return price_discount;
	}

	public void setPrice_discount(String price_discount) {
		this.price_discount = price_discount;
	}



}
