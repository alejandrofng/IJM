package com.IJM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJM.dto.CategoryDto;
import com.IJM.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	// create a category
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createCategory(@RequestBody CategoryDto categoryDto) {
		if (categoryService.isCategoryNameAlreadyExists(categoryDto)) {
			System.out.println("A Category with name " + categoryDto.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		categoryService.saveCategory(categoryDto);
		System.out.println("A Category with name " + categoryDto.getName() + " has been added");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateCategory(@PathVariable("code") long code, @RequestBody CategoryDto categoryDto) {
		System.out.println("Updating Category " + code);
		HttpStatus status;
		if(categoryService.isCategoryExists(code))
		{
			try {
				categoryService.updateCategory(categoryDto);
				status = HttpStatus.OK;
			} catch (Exception e) {
				status = HttpStatus.CONFLICT;
			}
		}
		else status = HttpStatus.NO_CONTENT;
		return new ResponseEntity<Void>(status);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDto>> listAllCategories() {
		List<CategoryDto> categoriesDto = categoryService.findAllCategoriesDto();
		if (categoriesDto==null) {
			return new ResponseEntity<List<CategoryDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CategoryDto>>(categoriesDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("code") long code) {
		System.out.println("Fetching Category with code " + code);

		CategoryDto categoryDto = categoryService.findCategoryDtoByCode(code);
		if (categoryDto == null) {
			System.out.println("Category with code " + code + " not found");
			return new ResponseEntity<CategoryDto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<CategoryDto> deleteCategory(@PathVariable("code") long code) {
		System.out.println("Fetching & Deleting Category with id " + code);

		
		if (!categoryService.isCategoryExists(code)) {
			System.out.println("Unable to delete. Category with code " + code + " not found");
			return new ResponseEntity<CategoryDto>(HttpStatus.NOT_FOUND);
		}
		
		categoryService.deleteCategory(code);
		return new ResponseEntity<CategoryDto>(HttpStatus.NO_CONTENT);
	}
}
