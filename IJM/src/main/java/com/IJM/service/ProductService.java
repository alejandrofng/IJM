package com.IJM.service;

import java.util.List;

import com.IJM.dto.ProductDto;

public interface ProductService {

	public void saveProduct(ProductDto  productDto);
	
	void updateProduct(ProductDto productDto, String code);
	
	public void deleteProduct(String code);
	
	public ProductDto findProductDtoByCode(String code);

	public List<ProductDto> findAllProductsDto();

	public boolean isProductExist(String code);
		
}
