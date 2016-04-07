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
		Category category = categoryDao.findById(categoryDto.getCode());
		category.setName(categoryDto.getName());
		Category parent = categoryDao.findById(categoryDto.getParent().getCode());
		category.setParent(parent);		
	}

	@Override
	public void deleteCategory(String code) {
		Category category = categoryDao.findById(Integer.parseInt(code));
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
	public CategoryDto findCategoryDtoByCode(String code) {
		Category category = categoryDao.findById(Integer.parseInt(code));
		return CategoryMapper.EntityToDto(category);
	}

	@Override
	public boolean isCategoryNameAlreadyExists(CategoryDto categoryDto) {
		
		if(categoryDao.findByParentAndName(categoryDto.getParent().getCode(), categoryDto.getName())!=null)
			return true;
		return false;
	}

	@Override
	public boolean isCategoryExists(String code) {
		if(categoryDao.findById(Integer.parseInt(code))!=null)
			return true;
		return false;
	}

}
