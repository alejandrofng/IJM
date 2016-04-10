package com.IJM.service;

import java.util.List;

import com.IJM.dto.ProductImageDto;

public interface ProductImageService {

	public void saveProductImage(ProductImageDto  productImageDto);
	
	void updateProductImage(ProductImageDto productImageDto, long code);
	
	public void deleteProductImage(long code);
	
	public ProductImageDto findProductImageDtoByCode(long code);

	public List<ProductImageDto> findAllProductsImageDto();

	public boolean isProductImageExist(long code);
}
