package com.IJMpiloto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.IJM.dao.ProductDao;
import com.IJM.model.Product;

public class ProductServiceImplTest{
/*
	@Mock
	private ProductDao productDao;

	@InjectMocks
	private ProductServiceImpl service;

	private Product product;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		fillDummyData();
	}

	@BeforeMethod
	public void resetMocks() {
		Mockito.reset(productDao);
	}

	@Test
	public void saveProductTest() throws Exception {
		Mockito.doNothing().when(productDao).save(Matchers.any(Product.class));

		service.saveProduct(product);

		Mockito.verify(productDao, Mockito.times(1)).save(Matchers.any(Product.class));
	}

	@Test
	public void updateProductTest() throws Exception {
		Mockito.when(productDao.findById(Matchers.anyLong())).thenReturn(product);

		service.updateProduct(product);

		Mockito.verify(productDao, Mockito.times(1)).findById(Matchers.anyLong());
	}

	@Test
	public void deleteProductTest() throws Exception {
		Mockito.doNothing().when(productDao).delete(Matchers.any(Product.class));

		service.deleteProduct(product);

		Mockito.verify(productDao, Mockito.times(1)).delete(Matchers.any(Product.class));
	}

	@Test
	public void findProductByIdTest() throws Exception {
		Mockito.when(productDao.findById(Matchers.anyLong())).thenReturn(product);

		Product s = service.findProductById(Matchers.anyLong());

		Assert.assertEquals(product, s);
		Mockito.verify(productDao, Mockito.times(1)).findById(Matchers.anyLong());
	}
	
	@Test
	public void findAllProductsTest() throws Exception {
		ArrayList<Product> products = new ArrayList<>();
		products.add(product);
		Mockito.when(productDao.findAll()).thenReturn(products);
		
		List<Product> response = service.findAllProducts();
		
		Assert.assertFalse(response.isEmpty());
		Assert.assertEquals(1, response.size());
		Assert.assertEquals(response.get(0), products.get(0));
		Mockito.verify(productDao, Mockito.times(1)).findAll();
	}
	
	@Test
	public void isProductExist_NotExistTest() throws Exception {
		List<Product> products = new ArrayList<>();
		
		//Mockito.when(productDao.findByCode(Matchers.anyString())).thenReturn(products);
		//Mockito.when(productDao.findByName(Matchers.anyString())).thenReturn(products);
		
		boolean response = service.isProductExist(product);
		
		Assert.assertFalse(response);
		//Mockito.verify(productDao, Mockito.times(1)).findByCode(Matchers.anyString());
		//Mockito.verify(productDao, Mockito.times(1)).findByName(Matchers.anyString());
	}
	
	@Test
	public void isProductExist_ExistTest() throws Exception {
		List<Product> products = new ArrayList<>();
		products.add(new Product());
		
		//Mockito.when(productDao.findByCode(Matchers.anyString())).thenReturn(products);
		//Mockito.when(productDao.findByName(Matchers.anyString())).thenReturn(products);
		
		boolean response = service.isProductExist(product);
		
		Assert.assertTrue(response);
		//Mockito.verify(productDao, Mockito.times(1)).findByCode(Matchers.anyString());
		//Mockito.verify(productDao, Mockito.never()).findByName(Matchers.anyString());
	}
	
	@Test(enabled = false)
	public void findProductProductsByIdTest() throws Exception {
		
	}
	
	private void fillDummyData() {
		Product p1 = new Product();
		p1.setCode("ProductCode_01");
		p1.setDescription("ProductDescription_01");
		Set<Product> products = new HashSet<>();
		products.add(p1);

		product = new Product();
		product.setCode("ProductCode_01");
		product.setDescription("ProductName_01");
	}*/
}
