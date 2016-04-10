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

import com.IJM.dto.ProductImageDto;
import com.IJM.service.ProductImageService;

@RestController
@RequestMapping("/productImage")
public class ProductImageController {
	@Autowired
	private ProductImageService productImageService;

	// create a Product
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createProduct(@RequestBody ProductImageDto productImageDto) {
		productImageService.saveProductImage(productImageDto);
		System.out.println("A ProductImageDto with name " + productImageDto.getId() + " has been added");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateProduct(@PathVariable("code") long code, @RequestBody ProductImageDto productImageDto) {
		System.out.println("Updating ProductImageDto " + code);
		HttpStatus status;
		try {
			productImageService.updateProductImage(productImageDto, code);
			status = HttpStatus.OK;
		} catch (Exception e) {
			status = HttpStatus.CONFLICT;
		}
		return new ResponseEntity<Void>(status);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductImageDto>> listAllProducts() {
		List<ProductImageDto> productsImageDto = productImageService.findAllProductsImageDto();
		if (productsImageDto.isEmpty()) {
			return new ResponseEntity<List<ProductImageDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProductImageDto>>(productsImageDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ResponseEntity<ProductImageDto> getProduct(@PathVariable("code") long code) {
		System.out.println("Fetching ProductImageDto with id " + code);

		ProductImageDto productimageDto = productImageService.findProductImageDtoByCode(code);
		if (productimageDto == null) {
			System.out.println("ProductImageDto with id " + code + " not found");
			return new ResponseEntity<ProductImageDto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductImageDto>(productimageDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<ProductImageDto> deleteSupplier(@PathVariable("code") long code) {
		System.out.println("Fetching & Deleting ProductImageDto with id " + code);

		
		if (productImageService.findProductImageDtoByCode(code)==null) {
			System.out.println("Unable to delete. ProductImageDto with id " + code + " not found");
			return new ResponseEntity<ProductImageDto>(HttpStatus.NOT_FOUND);
		}
		
		productImageService.deleteProductImage(code);
		return new ResponseEntity<ProductImageDto>(HttpStatus.NO_CONTENT);
	}
}

