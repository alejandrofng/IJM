package com.IJM.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJM.model.Image;
import com.IJM.model.Product;
import com.IJM.service.ImageService;
import com.IJM.service.ProductService;
import com.IJM.util.FileDeleter;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ImageService imageService;
	
	private static final String productImagePath="C:\\IJM\\Images\\Product\\";
	
	@RequestMapping(value = "/product/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<Image> deleteProductImage(@PathVariable("code") String code) {
		System.out.println("Fetching & Deleting Image for product " + code);
		code = code.toUpperCase();
		
		if (!productService.isProductExist(code)) {
			System.out.println("Product with code " + code + " not found");
			return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
		}
		else
		{
			Product product = productService.findProductByCode(code);
			if(product.getImages()!=null)
			{
				for(Image image:product.getImages())
				{
				    image.setProduct(null);
				    product.getImages().remove(image);
				}
				productService.saveProduct(product);
				try{
		    		
		    		File file = new File(productImagePath+code);
		        	
		    		if(FileDeleter.removeDirectory(file)){
		    			System.out.println(file.getName() + " is deleted!");
		    		}else{
		    			System.out.println("Delete operation is failed.");
		    		}
		    	   
		    	}catch(Exception e){
		    		
		    		e.printStackTrace();
		    		
		    	}
			}
		}
		
		return new ResponseEntity<Image>(HttpStatus.NO_CONTENT);
	}
}
