package com.IJM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.ProductImageDao;
import com.IJM.model.ProductImage;


@Transactional
@Service("productImageService")
public class ProductImageServiceImpl implements ProductImageService{

	@Autowired
	ProductImageDao productImageDao;

	@Override
	public void saveProduct(ProductImage productImage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(ProductImage productImage, long code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductImage findProductImageByCode(long code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductImage> findAllProductsImageDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isProductImageExist(long code) {
		// TODO Auto-generated method stub
		return false;
	}

}
