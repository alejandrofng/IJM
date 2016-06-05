package com.IJM.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@NotNull
	@Size(min = 3, max = 10)
	@Column(name = "Code", nullable = false)
	private String code;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Size( max = 50)
	@Column(name = "Description", nullable = false)
	private String description;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id_Category")
	private Category category;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id_Unit")
	private Unit unit;
	
	@Column(name = "Price_regular", nullable = false)
	private String price_regular;
	
	@Column(name = "Price_Discount")
	private String price_discount;
	
	@OneToMany(cascade = CascadeType.ALL,
			fetch= FetchType.EAGER,
			orphanRemoval = true,
			mappedBy="product")
	private Set<Image> images;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public String getPrice_regular() {
		return price_regular;
	}

	public void setPrice_regular(String price_regular) {
		this.price_regular = price_regular;
	}

	public String getPrice_discount() {
		return price_discount;
	}

	public void setPrice_discount(String price_discount) {
		this.price_discount = price_discount;
	}


	
	
}