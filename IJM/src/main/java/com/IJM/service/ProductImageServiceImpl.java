package com.IJM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.ProductImageDao;
import com.IJM.dto.ProductImageDto;


@Transactional
@Service("productImageService")
public class ProductImageServiceImpl implements ProductImageService{

	@Autowired
	ProductImageDao productImageDao;

	@Override
	public void saveProductImage(ProductImageDto productImageDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductImage(ProductImageDto productImageDto, long code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductImage(long code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductImageDto findProductImageDtoByCode(long code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductImageDto> findAllProductsImageDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isProductImageExist(long code) {
		// TODO Auto-generated method stub
		return false;
	}


}
