package com.IJM.service;

import java.util.List;

import com.IJM.model.ProductImage;


public interface ProductImageService {

	public void saveProduct(ProductImage  productImage);
	
	void updateProduct(ProductImage productImage, long code);
	
	public void deleteProduct(String code);
	
	public ProductImage findProductImageByCode(long code);

	public List<ProductImage> findAllProductsImageDto();

	public boolean isProductImageExist(long code);
}
