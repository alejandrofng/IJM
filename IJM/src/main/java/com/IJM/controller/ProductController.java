package com.IJM.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJM.dto.ProductDto;
import com.IJM.model.Image;
import com.IJM.model.Product;
import com.IJM.service.ProductService;
import com.IJM.util.FileAlreadyExistsException;
import com.IJM.util.ImageToFileConverter;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// create a Product
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
		if (productService.isProductExist(productDto.getCode())) {
			System.out.println("A Product with name " + productDto.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		Product product = productService.saveProduct(productDto);
		if(!product.getImages().isEmpty())
		{
			Set<Image> images = product.getImages();
			for(Image image:images)
			{
				image.setProduct(product);
				try {
					ImageToFileConverter.convertStringToFile(image);
				} catch (NullPointerException | FileAlreadyExistsException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("A Product with name " + productDto.getName() + " has been added");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateProduct(@PathVariable("code") String code, @RequestBody ProductDto productDto) {
		System.out.println("Updating Product " + code);
		HttpStatus status;
		try {
			productService.updateProduct(productDto, code);
			status = HttpStatus.OK;
		} catch (Exception e) {
			status = HttpStatus.CONFLICT;
		}
		return new ResponseEntity<Void>(status);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductDto>> listAllProducts() {
		List<ProductDto> products = productService.findAllProductsDto();
		if (products.isEmpty()) {
			return new ResponseEntity<List<ProductDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ResponseEntity<ProductDto> getProduct(@PathVariable("code") String code) {
		System.out.println("Fetching Product with code " + code);

		//ProductDto productDto = productService.findProductDtoByCode(code);
		ProductDto productDto = productService.findProductDtoByCode(code);
		if (productDto == null) {
			System.out.println("Product with code " + code + " not found");
			return new ResponseEntity<ProductDto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<ProductDto> deleteProduct(@PathVariable("code") String code) {
		System.out.println("Fetching & Deleting Product with id " + code);

		
		if (!productService.isProductExist(code)) {
			System.out.println("Unable to delete. Product with code " + code + " not found");
			return new ResponseEntity<ProductDto>(HttpStatus.NOT_FOUND);
		}
		
		productService.deleteProduct(code);
		return new ResponseEntity<ProductDto>(HttpStatus.NO_CONTENT);
	}
}
