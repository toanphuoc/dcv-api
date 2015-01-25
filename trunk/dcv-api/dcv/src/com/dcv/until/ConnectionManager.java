package com.dcv.until;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class ConnectionManager {

	public JdbcTemplate jdbcTemplate;
	
	public DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public String prepareDynamicStoredProcedure(String query) {
		return "call exceQueryByProcedure('" + query + "')";
	}
}
