package com.IJM.clientcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.IJM.model.Category;
import com.IJM.model.Product;
import com.IJM.service.CategoryService;
import com.IJM.service.ProductService;

@Controller
@RequestMapping("/productos")
public class ProductClientController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewAll()
	{
		List<Product> products = productService.findAllProducts();
		List<Category> categories = categoryService.findAllCategories();
		ModelAndView model = new ModelAndView("/product/view");
		model.addObject("products",products);
		model.addObject("categories",categories);
		return model;
	}
}
