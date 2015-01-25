package com.dcv.restws;

import java.util.List;

import com.dcv.dto.Product;

public interface ProductController {

	/**
	 * Get all product by trademark
	 * @param trademarkId
	 * @return
	 */
	public List<Product> getProductsByTrademark(int trademarkId);
	
	/**
	 * Get all product by category
	 * @param categoriId
	 * @return
	 */
	public List<Product> getProductsByCategory(int categoriId);
	
	/**
	 * Get 10 new product
	 * @return
	 */
	public List<Product> getTopTenNewProduct();
	
	/**
	 * 
	 * Get product by id
	 * @param id
	 * @return
	 */
	public Product getProductById(int id);
}
