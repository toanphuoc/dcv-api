package com.dcv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.dcv.dto.Category;
import com.dcv.dto.Product;
import com.dcv.dto.ProductImage;
import com.dcv.dto.Trademark;
import com.dcv.until.ConnectionManager;

public class ProductDaoImpl extends ConnectionManager implements ProductDao{

	@Autowired
	private TrademarkDao trademarkDao;
	
	@Autowired
	private CategoriDao categoriDao;
	
	@Autowired
	private ProductImageDao productImageDao;
	
	@Override
	public List<Product> getProductsByTrademark(int trademarkId) {
		String sql = "CALL getProductByTrademark(?)";
		RowMapper<Product> mapper = new RowMapper<Product>() {
			
			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDate_created(rs.getString("date_created"));
				product.setDecription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				
				Trademark trademark = trademarkDao.getTrademarkById(rs.getInt("trademark_id"));
				product.setTrademark(trademark);
				
				Category category = categoriDao.getCategoryById(rs.getInt("category_id"));
				product.setCategory(category);
				
				ProductImage productImg = productImageDao.getMainImageOfProduct(rs.getInt("id"));
				product.setImage(productImg.getImage());
				return product;
			}
		};
		return jdbcTemplate.query(sql, mapper, trademarkId);
	}

	@Override
	public List<Product> getProductsByCategory(int categoriId) {
		String sql = "CALL getProductByCategory(?)";
		RowMapper<Product> mapper = new RowMapper<Product>() {
			
			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDate_created(rs.getString("date_created"));
				product.setDecription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				
				Trademark trademark = trademarkDao.getTrademarkById(rs.getInt("trademark_id"));
				product.setTrademark(trademark);
				
				Category category = categoriDao.getCategoryById(rs.getInt("category_id"));
				product.setCategory(category);
				
				ProductImage productImg = productImageDao.getMainImageOfProduct(rs.getInt("id"));
				product.setImage(productImg.getImage());
				return product;
			}
		};
		return jdbcTemplate.query(sql, mapper, categoriId);
	}

	@Override
	public List<Product> getTopTenNewProduct() {
		String sql = "CALL getTopTenProducts()";
		RowMapper<Product> mapper = new RowMapper<Product>() {
			
			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDate_created(rs.getString("date_created"));
				product.setDecription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				
				Trademark trademark = trademarkDao.getTrademarkById(rs.getInt("trademark_id"));
				product.setTrademark(trademark);
				
				Category category = categoriDao.getCategoryById(rs.getInt("category_id"));
				product.setCategory(category);
				
				ProductImage productImg = productImageDao.getMainImageOfProduct(rs.getInt("id"));
				product.setImage(productImg.getImage());
				return product;
			}
		};
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public Product getProductById(int id) {
		String sql = "CALL getProductById(?)";
		RowMapper<Product> mapper = new RowMapper<Product>() {
			
			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDate_created(rs.getString("date_created"));
				product.setDecription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				
				Trademark trademark = trademarkDao.getTrademarkById(rs.getInt("trademark_id"));
				product.setTrademark(trademark);
				
				Category category = categoriDao.getCategoryById(rs.getInt("category_id"));
				product.setCategory(category);
				return product;
			}
		};
		List<Product> lst = jdbcTemplate.query(sql, mapper, id);
		if(lst.size() > 0 && lst.size() < 2)
			return lst.get(0);
		return null;
	}

}
