package com.IJM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
=======
>>>>>>> refs/remotes/origin/ijm_simple
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;

	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "Name", nullable = false)
	private String name;
<<<<<<< HEAD

	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	
    @JoinColumn(name="Id_Parent")
	private Category parent;
	
	@OneToMany(fetch = FetchType.LAZY) 
	@JoinColumn(name = "parent")
	private Set<Category> children;

	public int getId() {
=======
	
	public long getId() {
>>>>>>> refs/remotes/origin/ijm_simple
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
