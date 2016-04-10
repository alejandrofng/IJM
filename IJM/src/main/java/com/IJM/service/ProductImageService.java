package com.IJM.service;

import java.util.List;

import com.IJM.dto.ProductImageDto;

public interface ProductImageService {

	public void saveProduct(ProductImageDto  productImageDto);
	
	void updateProduct(ProductImageDto productImageDto, long code);
	
	public void deleteProduct(String code);
	
	public ProductImageDto findProductImageDtoByCode(long code);

	public List<ProductImageDto> findAllProductsImageDto();

	public boolean isProductImageExist(long code);
}
