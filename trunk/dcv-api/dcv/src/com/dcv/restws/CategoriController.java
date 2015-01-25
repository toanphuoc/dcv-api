package com.dcv.restws;

import java.util.List;

import com.dcv.dto.Category;

public interface CategoriController {

	/**
	 * Get all categories
	 * @return
	 */
	public List<Category> getAllCategories();
	
	/**
	 * Get categories by trademark
	 * @param trademarkId
	 * @return
	 */
	public List<Category> getCategorisByTrademark(int trademarkId);
	
	/**
	 * Get category by id
	 * @param id
	 * @return
	 */
	public Category getCategoryById(int id);
}
