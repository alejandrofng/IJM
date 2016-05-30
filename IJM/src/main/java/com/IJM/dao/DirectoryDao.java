package com.IJM.dao;

import java.util.List;

import com.IJM.model.Directory;

public interface DirectoryDao {
	public void save(Directory directory);

	public void delete(Directory directory);

	public List<Directory> findAll();

	public Directory findById(long id);

	public void update(Directory directory);
	
	public Directory findByName(String name);
}
