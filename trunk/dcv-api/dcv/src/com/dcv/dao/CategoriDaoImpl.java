package com.dcv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.dcv.dto.Category;
import com.dcv.dto.Trademark;
import com.dcv.until.ConnectionManager;

public class CategoriDaoImpl extends ConnectionManager implements CategoriDao {

	@Autowired
	private TrademarkDao trademarkDao;
	
	@Override
	public List<Category> listCategory() {
		String sql = "SELECT id, name, trademark_id FROM categories ORDER BY name";
		RowMapper<Category> mapper = new RowMapper<Category>() {
			
			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				Trademark trademark = trademarkDao.getTrademarkById(rs.getInt("trademark_id"));
				category.setTrademark(trademark);
				return category;
			}
		};
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<Category> listCategoryByTrademark(int trademarkId) {
		String sql = "SELECT id, name, trademark_id FROM categories WHERE trademark_id = ? ORDER BY name";
		RowMapper<Category> mapper = new RowMapper<Category>() {
			
			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				Trademark trademark = trademarkDao.getTrademarkById(rs.getInt("trademark_id"));
				category.setTrademark(trademark);
				return category;
			}
		};
		return jdbcTemplate.query(sql, mapper, trademarkId);
	}

	@Override
	public Category getCategoryById(int id) {
		String sql  = "SELECT id, name, trademark_id FROM categories WHERE id = ?";
		RowMapper<Category> mapper = new RowMapper<Category>() {
			
			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				Trademark trademark = trademarkDao.getTrademarkById(rs.getInt("trademark_id"));
				category.setTrademark(trademark);
				return category;
			}
		};
		List<Category> lst = jdbcTemplate.query(sql, mapper, id);
		if(lst.size() > 0 && lst.size() < 2)
			return lst.get(0);
		return null;
	}

}
