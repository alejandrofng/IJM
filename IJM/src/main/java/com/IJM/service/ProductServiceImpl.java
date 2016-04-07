package com.IJM.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.ProductDao;
import com.IJM.dto.ProductDto;
import com.IJM.mapper.ProductMapper;
import com.IJM.model.Product;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDAO;

	@Override
	public void saveProduct(ProductDto productDto) {
		Product product = ProductMapper.DtoToEntity(productDto);
		productDAO.save(product);
	}

	@Override
	public void updateProduct(ProductDto productDto, String code) {
		Product product = productDAO.findByCode(code);
		if (product != null) {
			product.setCode(productDto.getCode());
			product.setDescription(productDto.getDescription());
			product.setName(productDto.getName());
		}
		productDAO.update(product);
	}

	@Override
	public void deleteProduct(String code) {
		Product product = productDAO.findByCode(code);
		productDAO.delete(product);
	}

	@Override
	public ProductDto findProductDtoByCode(String code) {
		Product product = productDAO.findByCode(code);
		if(product!=null)
		{
		return ProductMapper.EntityToDto(product);
		}
		else return null;
	}

	@Override
	public List<ProductDto> findAllProductsDto() {
		List<Product> products = productDAO.findAll();
		List<ProductDto> productsDto = new LinkedList<>();
		for (Product product : products) {
			ProductDto productDto = ProductMapper.EntityToDto(product);
			productsDto.add(productDto);
		}
		return productsDto;
	}

	@Override
	public boolean isProductExist(String code) {
		return (productDAO.findByCode(code)!=null);
	}

	@Override
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
