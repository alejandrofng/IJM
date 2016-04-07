package com.IJM.service;

import java.util.List;

import com.IJM.dto.ProductImageDto;
import com.IJM.model.ProductImage;


public interface ProductImageService {

	public void saveProductImage(ProductImageDto  productImageDto);
	
	void updateProductImage(ProductImageDto ProductImageDto);
	
	public void deleteProductImage(int id);

	public List<ProductImageDto> findAllProductsImageDto();
	
	public ProductImageDto EntityToDto(ProductImage productImage);
	
	public ProductImage DtoToEntity(ProductImageDto productImageDto);
	
	public ProductImageDto findProductImageDtoById (int id);
}
