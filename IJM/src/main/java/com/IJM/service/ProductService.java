package com.IJM.service;

import java.util.List;

import com.IJM.model.Product;

public interface ProductService {

	public void saveProduct(Product  product);
	
	void updateProduct(Product product);
	
	public void deleteProduct(String code);
	
	public Product findProductDtoByCode(String code);

	public List<Product> findAllProductsDto();

	public boolean isProductExist(String code);
		
}
