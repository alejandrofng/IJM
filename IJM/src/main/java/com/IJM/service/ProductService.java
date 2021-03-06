package com.IJM.service;

import java.util.List;

import com.IJM.dto.ProductDto;
import com.IJM.model.Product;

public interface ProductService {

	public Product saveProduct(ProductDto  productDto);
	
	public Product saveProduct(Product product);
	
	public Product updateProduct(ProductDto productDto, String code);
	
	public void deleteProduct(String code);
	
	public ProductDto findProductDtoByCode(String code);

	public List<ProductDto> findAllProductsDto();

	public boolean isProductExist(String code);

	public List<Product> findAllProducts();
	
	public ProductDto findProductDto(Long id);
	
	public Product findProductByCode(String code);

	void updateProduct(Product product);

}
