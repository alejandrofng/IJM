package com.IJM.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@NotNull
	@Size(min = 3, max = 10)
	@Column(name = "Code", nullable = false)
	private String code;

	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Size(min = 5, max = 50)
	@Column(name = "Description", nullable = false)
	private String description;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id_Category")
	private Category category;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id_Unit")
	private Unit unit;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		if(this.category==null||!this.category.equals(category))
		{
			this.category=category;
		}
		return;
	}
	
	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		if(this.unit==null||!this.unit.equals(unit))
		{
			this.unit=unit;
		}
		return;
	}
	
	
	
}