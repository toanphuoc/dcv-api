package com.dcv.dao;

import java.util.List;

import com.dcv.dto.ProductImage;

public interface ProductImageDao {

	/**
	 * Get product image of product
	 * @param productId
	 * @return
	 */
	public List<ProductImage> getProductImageOfProduct(int productId);
}
