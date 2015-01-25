package com.dcv.service;

import java.util.List;

import com.dcv.dto.ProductImage;

public interface ProductImageService {

	/**
	 * Get product images of product
	 * @param productId
	 * @return
	 */
	public List<ProductImage> getProductImageOfProduct(int productId);
}
