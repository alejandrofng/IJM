package com.IJM.mapper;

import com.IJM.dto.ProductDto;
import com.IJM.model.Product;
import com.IJM.mapper.CategoryMapper;

public class ProductMapper {

	public static ProductDto EntityToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setCode(product.getCode());
		productDto.setDescription(product.getDescription());
		productDto.setName(product.getName());
		if(product.getCategory()!=null)
			productDto.setCategoryDto(CategoryMapper.EntityToDto(product.getCategory()));
		if(product.getUnit()!=null)
			productDto.setUnitDto(UnitMapper.EntityToDto(product.getUnit()));
		return productDto;
	}

	public static Product DtoToEntity(ProductDto productDto) {
		Product product = new Product();
		product.setCode(productDto.getCode());
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		if(productDto.getCategoryDto()!=null)
			product.setCategory(CategoryMapper.DtoToEntity(productDto.getCategoryDto()));
		if(productDto.getUnitDto()!=null)
			product.setUnit(UnitMapper.DtoToEntity(productDto.getUnitDto()));
		return product;
	}
}
