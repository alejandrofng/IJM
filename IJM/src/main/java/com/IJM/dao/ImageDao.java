package com.IJM.dao;

import java.util.List;

import com.IJM.model.Image;

public interface ImageDao {
	public void save(Image image);

	public void delete(Image image);

	public List<Image> findAll();

	public Image findById(long id);

	public void update(Image image);
}
