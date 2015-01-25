package com.dcv.dao;

import java.util.List;

import com.dcv.dto.Category;

public interface CategoriDao {

	/**
	 * Get all categories
	 * @return
	 */
	public List<Category> listCategory();
	
	/**
	 * Get list categories by trademark
	 * @param trademarkId
	 * @return
	 */
	public List<Category> listCategoryByTrademark(int trademarkId);
	
	/**
	 * Get category by id
	 * @param id
	 * @return
	 */
	public Category getCategoryById(int id);
}
