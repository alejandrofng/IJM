package com.IJM.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.ProductDao;
import com.IJM.dto.ProductDto;
import com.IJM.mapper.ProductMapper;
import com.IJM.model.Image;
import com.IJM.model.Product;
import com.IJM.util.FileAlreadyExistsException;
import com.IJM.util.ImageToFileConverter;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDAO;
	
	@Autowired
	private DirectoryService directoryService;

	private ProductMapper productMapper = new ProductMapper();
	
	@Override
	public Product saveProduct(ProductDto productDto) {
		Product product = productMapper.DtoToEntity(productDto,directoryService);
		productDAO.save(product);
		return product;
	}
	
	public Product saveProduct(Product product) {
		productDAO.save(product);
		return product;
	}

	@Override
	public void updateProduct(ProductDto productDto, String code) {
		Product product = productDAO.findByCode(code);
		if (product != null) {
			productMapper.DtoToEntity(productDto, product);
			productDAO.update(product);
		}
	}
	
	@Override
	public void updateProduct(Product product)
	{
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
			return productMapper.EntityToDto(product);
		}
		else return null;
	}
	@Override
	public ProductDto findProductDto(Long id) {
		Product product = productDAO.findById(id);
		if(product!=null)
		{
			return productMapper.EntityToDto(product);
		}
		else return null;
	}
	@Override
	public List<ProductDto> findAllProductsDto() {
		List<Product> products = productDAO.findAll();
		List<ProductDto> productsDto = new LinkedList<>();
		for (Product product : products) {
			ProductDto productDto = productMapper.EntityToDto(product);
			productsDto.add(productDto);
		}
		return productsDto;
	}

	@Override
	public boolean isProductExist(String code) {
		return (productDAO.findByCode(code)!=null);
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = productDAO.findAll();
		return products;
	}

	@Override
	public Product findProductByCode(String code) {
		Product product = productDAO.findByCode(code);
		return product;
	}
	
}
