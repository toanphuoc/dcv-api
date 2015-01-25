package com.dcv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcv.dto.ProductImage;

public class ProductImageServiceImpl implements ProductImageService{

	@Autowired
	private ProductImageService productImageDao;
	@Override
	public List<ProductImage> getProductImageOfProduct(int productId) {
		return productImageDao.getProductImageOfProduct(productId);
	}

}
