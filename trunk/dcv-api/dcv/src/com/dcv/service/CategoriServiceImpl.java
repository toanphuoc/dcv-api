package com.dcv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcv.dao.CategoriDao;
import com.dcv.dto.Category;

public class CategoriServiceImpl implements CategoriService {

	@Autowired
	private CategoriDao categoriDao;
	
	@Override
	public List<Category> getAllCategories() {
		return categoriDao.listCategory();
	}

	@Override
	public List<Category> getCategoriesByTrademark(int trademarkId) {
		return categoriDao.listCategoryByTrademark(trademarkId);
	}

	@Override
	public Category getCategoryById(int id) {
		return categoriDao.getCategoryById(id);
	}

}
