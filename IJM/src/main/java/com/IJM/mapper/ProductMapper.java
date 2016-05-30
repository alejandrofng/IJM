package com.IJM.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.IJM.dto.ProductDto;
import com.IJM.model.Directory;
import com.IJM.model.Image;
import com.IJM.model.Product;
import com.IJM.service.DirectoryService;
import com.IJM.mapper.CategoryMapper;

public class ProductMapper {
	
	private CategoryMapper categoryMapper = new CategoryMapper();
	
	private ImageMapper imageMapper = new ImageMapper();
	
	private String name = "Product_Image";

	  public ProductDto EntityToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setCode(product.getCode());
		productDto.setDescription(product.getDescription());
		productDto.setName(product.getName());
		if(product.getCategory()!=null)
			productDto.setCategory(categoryMapper.EntityToDto(product.getCategory()));
		if(product.getUnit()!=null)
			productDto.setUnit(UnitMapper.EntityToDto(product.getUnit()));
		if(product.getImages()!=null)
		{
			productDto.setImages(imageMapper.EntitySetToDtoSet(product.getImages()));
		}
		return productDto;
	  }

	public Product DtoToEntity(ProductDto productDto, DirectoryService ds) {
		Product product = new Product();
		product.setCode(productDto.getCode());
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		if(productDto.getCategory()!=null)
			product.setCategory(categoryMapper.DtoToEntity(productDto.getCategory()));
		if(productDto.getUnit()!=null)
			product.setUnit(UnitMapper.DtoToEntity(productDto.getUnit()));
		if(productDto.getImages()!=null)
		{
			product.setImages(imageMapper.DtoSetToEntitySet(productDto.getImages(),ds.findDirectoryByName(name)));
			for(Image image: product.getImages())
			{
				image.setProduct(product);
			}
		}
		return product;
	}
	public void DtoToEntity(ProductDto productDto,Product product) {//Map an existent Entity to update
		product.setCode(productDto.getCode());
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		if(productDto.getCategory()!=null)
			product.setCategory(categoryMapper.DtoToEntity(productDto.getCategory()));
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

	public CategoryMapper getCategoryMapper() {
		return categoryMapper;
	}

	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

	public ImageMapper getImageMapper() {
		return imageMapper;
	}

	public void setImageMapper(ImageMapper imageMapper) {
		this.imageMapper = imageMapper;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
