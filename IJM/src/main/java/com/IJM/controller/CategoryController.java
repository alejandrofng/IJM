package com.IJM.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.IJM.model.Category;
import com.IJM.service.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewAll()
	{
		//List<Category> categories = categoryService.findAllCategories();
		ModelAndView model = new ModelAndView("/category/viewCategorias");
		//model.addObject("categories",categories);
		return model;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public ModelAndView insert()
	{
		List<Category> categories = categoryService.findAllRootCategories();
		ModelAndView model = new ModelAndView("/category/insert");
		model.addObject("categories",categories);
		return model;
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ModelAndView processInsertion(@Valid @ModelAttribute("category") Category category, BindingResult result )
	{
		if(result.hasErrors())
		{
			ModelAndView model = new ModelAndView("/category/insert");
			model.addObject("message","Un error ha ocurrido");
			return model;
		}
		categoryService.saveCategory(category);
		return viewAll();
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id )
	{
		ModelAndView model = new ModelAndView("/category/insert");
		Category category = categoryService.findCategoryByCode(id);
		List<Category> categories = categoryService.findAllRootCategories();
		model.addObject("category",category);
		model.addObject("categories",categories);
		return model;
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public ModelAndView processUpdate(@Valid @ModelAttribute("category") Category category, BindingResult result )
	{	
		if(result.hasErrors())
		{
			ModelAndView model = new ModelAndView("/category/insert");
			model.addObject("message","Un error ha ocurrido");
			return model;
		}
		categoryService.updateCategory(category);
		ModelAndView model = new ModelAndView("redirect:http://localhost:8090/IJM/category");
		return model;
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public ModelAndView delete(@PathVariable("id") long id )
	{
		categoryService.deleteCategory(id);
		ModelAndView model = new ModelAndView("redirect:http://localhost:8090/IJM/category");
		return model;
	}
}
