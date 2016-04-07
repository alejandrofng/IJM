package com.IJM.service;

import java.util.List;
import java.util.Set;

import com.IJM.dto.ProductDto;
import com.IJM.model.Product;

public interface ProductService {

	public void saveProduct(ProductDto  product);
	
	void updateProduct(ProductDto productDto, String code);
	
	public void deleteProduct(String code);
	
	public ProductDto findProductDtoByCode(String code);

	public List<ProductDto> findAllProductsDto();

	public boolean isProductExist(String code);
	
	public Set<ProductDto> EntitySetToDtoSet(Set<Product> products);
	
}
