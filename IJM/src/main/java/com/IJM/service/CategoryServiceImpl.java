package com.IJM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.CategoryDao;
import com.IJM.dto.CategoryDto;
import com.IJM.model.Category;
import com.IJM.mapper.CategoryMapper;

@Transactional
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public void saveCategory(CategoryDto categoryDto) {
		Category category = CategoryMapper.DtoToEntity(categoryDto);
		categoryDao.save(category);
	}

	@Override
	public void updateCategory(CategoryDto categoryDto) {
		Category category = categoryDao.findById(categoryDto.getId());
		category.setName(categoryDto.getName());
		if(categoryDto.getId_parent()!=null&&isCategoryExists(categoryDto.getId_parent()))
		{
			Category parent = new Category();
			parent.setId(categoryDto.getId_parent());
			category.setParent(parent);
		}
		else category.setParent(null);
		categoryDao.update(category);
	}

	@Override
	public void deleteCategory(long code) {
		Category category = categoryDao.findById(code);
		categoryDao.delete(category);
	}

	@Override
	public List<CategoryDto> findAllCategoriesDto() {
		List<Category> categories = categoryDao.findAll();
		if(!categories.isEmpty())
		{
			return CategoryMapper.EntityListToDtoList(categories);
		}
		else return null;
	}

	@Override
	public CategoryDto findCategoryDtoByCode(long code) {
		Category category = categoryDao.findById(code);
		return CategoryMapper.EntityToDto(category);
	}

	@Override
	public boolean isCategoryNameAlreadyExists(CategoryDto categoryDto) {
		
		if(categoryDao.findByName(categoryDto.getName())!=null)
			return true;
		return false;
	}

	@Override
	public boolean isCategoryExists(long code) {
		if(categoryDao.findById(code)!=null)
			return true;
		return false;
	}
	@Override
	public List<Category> findAllCategories() {
		List<Category> categories = categoryDao.findAll();
		return categories;
	}

}
