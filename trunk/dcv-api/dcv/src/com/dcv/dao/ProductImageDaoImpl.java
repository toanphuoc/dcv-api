package com.dcv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.dcv.dto.ProductImage;
import com.dcv.until.ConnectionManager;

public class ProductImageDaoImpl extends ConnectionManager implements ProductImageDao {

	@Override
	public List<ProductImage> getProductImageOfProduct(int productId) {
		String sql = "CALL getImagesOfProduct(?)";
		RowMapper<ProductImage> mapper = new RowMapper<ProductImage>() {

			@Override
			public ProductImage mapRow(ResultSet rs, int arg1)
					throws SQLException {
				ProductImage productImg = new ProductImage();
				productImg.setId(rs.getInt("id"));
				productImg.setProductId(rs.getInt("product_id"));
				productImg.setImage(rs.getString("image"));
				productImg.setMainImage(rs.getBoolean("product_image"));
				return productImg;
			}
		};
		return jdbcTemplate.query(sql, mapper, productId);
	}

	@Override
	public ProductImage getMainImageOfProduct(int productId) {
		String sql = "CALL getMainImageOfProduct(?)";
		RowMapper<ProductImage> mapper = new RowMapper<ProductImage>() {

			@Override
			public ProductImage mapRow(ResultSet rs, int arg1)
					throws SQLException {
				ProductImage productImg = new ProductImage();
				productImg.setId(rs.getInt("id"));
				productImg.setProductId(rs.getInt("product_id"));
				productImg.setImage(rs.getString("image"));
				productImg.setMainImage(rs.getBoolean("product_image"));
				return productImg;
			}
		};
		List<ProductImage> lst = jdbcTemplate.query(sql, mapper, productId);
		if(lst.size() > 0 && lst.size() < 2)
			return lst.get(0);
		return null;
	}

}
