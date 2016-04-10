package com.IJM.dto;

public class CategoryDto {

	private long code;
	
	private String name;
	
	private CategoryDto parent;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public CategoryDto getParent() {
		return parent;
	}

	public void setParent(CategoryDto parent) {
		this.parent = parent;
	}
	
}
