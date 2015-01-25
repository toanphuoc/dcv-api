package com.dcv.restws;

import java.util.List;

import com.dcv.dto.ProductImage;

public interface ProductImageController {

	/**
	 * 
	 * @param productId
	 * @return
	 */
	public List<ProductImage> getProductImageOfProduct(int productId);
} 
