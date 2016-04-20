package com.IJM.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.ProductDao;
import com.IJM.dao.ProductImageDao;
import com.IJM.model.Product;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDAO;

	@Autowired
	private ProductImageService productImageService;
	
	
	@Override
	public void saveProduct(Product product) {
		//adding attributes to image
		
		productDAO.save(product);
	}
	

	@Override
	public void updateProduct(Product newProduct) {
		productDAO.update(newProduct);//arreglar
	}

	@Override
	public void deleteProduct(String code) {
		Product product = productDAO.findByCode(code);
		productDAO.delete(product);
	}

	@Override
	public Product findProductByCode(String code) {
		Product product = productDAO.findByCode(code);
		return product;
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = productDAO.findAll();
		return products;
	}

	@Override
	public boolean isProductExist(String code) {
		return (productDAO.findByCode(code)!=null);
	}

}
