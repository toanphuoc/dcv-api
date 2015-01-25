package com.dcv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcv.dao.ProductDao;
import com.dcv.dto.Product;

public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getProductsByTrademark(int trademarkId) {
		return productDao.getProductsByTrademark(trademarkId);
	}

	@Override
	public List<Product> getProductsByCategory(int categoriId) {
		return productDao.getProductsByCategory(categoriId);
	}

	@Override
	public List<Product> getTopTenNewProduct() {
		return productDao.getTopTenNewProduct();
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

}
