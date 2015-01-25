package com.dcv.service;

import java.util.List;

import com.dcv.dto.Category;

public interface CategoriService {

	/**
	 * Get all categories
	 * @return
	 */
	public List<Category> getAllCategories();
	
	/**
	 * Get Categories by trademark
	 * @param trademarkId
	 * @return
	 */
	public List<Category> getCategoriesByTrademark(int trademarkId);
	
	/**
	 * Get category by id
	 * @param id
	 * @return
	 */
	public Category getCategoryById(int id);
}
