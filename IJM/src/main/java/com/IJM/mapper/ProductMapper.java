package com.IJM.mapper;

import java.util.HashSet;
import java.util.Set;

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
			productDto.setCategory(CategoryMapper.EntityToDto(product.getCategory()));
		if(product.getUnit()!=null)
			productDto.setUnit(UnitMapper.EntityToDto(product.getUnit()));
		if(product.getImages()!=null)
		{
			productDto.setImages(ImageMapper.EntitySetToDtoSet(product.getImages()));
		}
		return productDto;
	}

	public static Product DtoToEntity(ProductDto productDto) {
		Product product = new Product();
		product.setCode(productDto.getCode());
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		if(productDto.getCategory()!=null)
			product.setCategory(CategoryMapper.DtoToEntity(productDto.getCategory()));
		if(productDto.getUnit()!=null)
			product.setUnit(UnitMapper.DtoToEntity(productDto.getUnit()));
		if(productDto.getImages()!=null)
			product.setImages(ImageMapper.DtoSetToEntitySet(productDto.getImages()));
		return product;
	}
	public static void DtoToEntity(ProductDto productDto,Product product) {//Map an existent Entity to update
		product.setCode(productDto.getCode());
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		if(productDto.getCategory()!=null)
			product.setCategory(CategoryMapper.DtoToEntity(productDto.getCategory()));
		if(productDto.getUnit()!=null)
			product.setUnit(UnitMapper.DtoToEntity(productDto.getUnit()));
	}
	public Set<ProductDto> EntitySetToDtoSet(Set<Product> products) {
		Set<ProductDto> productsDto = new HashSet<ProductDto>();
		for (Product product : products) {
		    ProductDto productDto = new ProductDto();
		    productDto.setCode(product.getCode());
		    productDto.setDescription(product.getDescription());
		    productDto.setName(product.getName());
		    productsDto.add(productDto);
		}
		return productsDto;
	}
}
