package com.IJM.dto;

public class CategoryDto {

	private Long id;
	
	private String name;
	
	private Long id_parent;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getId_parent() {
		return id_parent;
	}

	public void setId_parent(long id_parent) {
		this.id_parent = id_parent;
	}
	
}
