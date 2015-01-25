package com.dcv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import com.dcv.dto.Trademark;
import com.dcv.until.ConnectionManager;

public class TrademarkDaoImpl extends ConnectionManager implements TrademarkDao{

	@Override
	public List<Trademark> getListTrademark() {
		String sql = "CALL getAllTrademarks()";
		RowMapper<Trademark> mapper = new RowMapper<Trademark>() {
			
			@Override
			public Trademark mapRow(ResultSet rs, int arg1) throws SQLException {
				Trademark trademarks = new Trademark();
				trademarks.setId(rs.getInt("id"));
				trademarks.setName(rs.getString("name"));
				trademarks.setDescription(rs.getString("description"));
				return trademarks;
			}
		};
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public Trademark getTrademarkById(int id) {
		
		String sql =  "CALL getTrademarkById(?)";
		RowMapper<Trademark> mapper = new RowMapper<Trademark>() {
			
			@Override
			public Trademark mapRow(ResultSet rs, int arg1) throws SQLException {
				Trademark trademarks = new Trademark();
				trademarks.setId(rs.getInt("id"));
				trademarks.setName(rs.getString("name"));
				trademarks.setDescription(rs.getString("description"));
				return trademarks;
			}
		};
		List<Trademark> lst = jdbcTemplate.query(sql, mapper, id);
		if(lst.size() > 0 && lst.size() < 2)
			return lst.get(0);
		return null;
	}

	@Override
	public boolean insertTrademark(String name, String description) {
		String sql = "CALL insertTrademarks(?, ?)";
		return jdbcTemplate.update(sql, name, description) == 1;
	}

	@Override
	public boolean updaateTrademark(int id, String name, String description) {
		String sql = "CALL updateTrademarks(?, ?, ?)";
		return jdbcTemplate.update(sql, id, name, description) == 1;
	}

}
