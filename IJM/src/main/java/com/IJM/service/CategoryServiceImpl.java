package com.IJM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.CategoryDao;
import com.IJM.model.Category;

@Transactional
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public void saveCategory(Category category) {
		categoryDao.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void deleteCategory(long code) {
		Category category = categoryDao.findById(code);
		categoryDao.delete(category);
	}

	@Override
	public List<Category> findAllCategories() {
		List<Category> categories = categoryDao.findAll();
		return categories;
	}

	@Override
	public Category findCategoryByCode(long code) {
		return null;
	}

	@Override
	public boolean isCategoryNameAlreadyExists(Category category) {
		
		if(categoryDao.findByName(category.getName())!=null)
			return true;
		return false;
	}

	@Override
	public boolean isCategoryExists(long code) {
		if(categoryDao.findById(code)!=null)
			return true;
		return false;
	}

}
