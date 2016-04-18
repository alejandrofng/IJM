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
import com.IJM.model.Product;
import com.IJM.model.Unit;
import com.IJM.service.CategoryService;
import com.IJM.service.ProductService;
import com.IJM.service.UnitService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	UnitService unitService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewAll()
	{
		List<Product> products = productService.findAllProducts();
		ModelAndView model = new ModelAndView("/product/viewAll");
		model.addObject("products",products);
		return model;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public ModelAndView insert()
	{
		ModelAndView model = new ModelAndView("/product/insert");
		List<Category> categories = categoryService.findAllCategories();
		List<Unit> units = unitService.findAllUnits();
		model.addObject("categories",categories);
		model.addObject("units",units);
		return model;
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ModelAndView processInsertion(@Valid @ModelAttribute("product") Product product, BindingResult result )
	{
		if(result.hasErrors())
		{
			ModelAndView model = new ModelAndView("/product/insert");
			model.addObject("message","Un error ha ocurrido");
			return model;
		}
		productService.saveProduct(product);
		return viewAll();
	}
	@RequestMapping(value="/update/{code}",method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("code") String code )
	{
		ModelAndView model = new ModelAndView("/product/insert");
		
		Product product = productService.findProductByCode(code);
		List<Category> categories = categoryService.findAllCategories();
		List<Unit> units = unitService.findAllUnits();
		
		model.addObject("product",product);
		model.addObject("categories",categories);
		model.addObject("units",units);
		return model;
	}
	@RequestMapping(value="/update/{code}",method=RequestMethod.POST)
	public ModelAndView processUpdate(@Valid @ModelAttribute("product") Product product, BindingResult result )
	{	
		if(result.hasErrors())
		{
			ModelAndView model = new ModelAndView("/product/insert");
			model.addObject("message","Un error ha ocurrido");
			return model;
		}
		productService.updateProduct(product);
		ModelAndView model = new ModelAndView("redirect:http://localhost:8090/IJM/product");
		return model;
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public ModelAndView delete(@PathVariable("code") String code )
	{
		productService.deleteProduct(code);
		ModelAndView model = new ModelAndView("redirect:http://localhost:8090/IJM/product");
		return model;
	}
}

