package com.dcv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.dcv.dto.Company;
import com.dcv.until.ConnectionManager;

public class CompanyDaoImpl extends ConnectionManager implements CompanyDao{

	@Override
	public Company getInfo() {
		String sql = "CALL getInfoCompany()";
		RowMapper<Company> mapper = new RowMapper<Company>() {
			
			@Override
			public Company mapRow(ResultSet rs, int arg1) throws SQLException {
				Company company = new Company();
				company.setName(rs.getString("name"));
				company.setAddress(rs.getString("address"));
				company.setTelephone(rs.getString("telephone"));
				company.setFax(rs.getString("fax"));
				company.setEmail(rs.getString("email"));
				return company;
			}
		};
		List<Company> lst = jdbcTemplate.query(sql, mapper);
		if(lst.size() > 0 && lst.size() < 2)
			return lst.get(0);
		return null;
	}

	@Override
	public boolean updateCompany(String name, String address, String telephone,
			String fax, String email) {
		String sql = "CALL updateCompany(?,?,?,?,?)";
		return jdbcTemplate.update(sql, name, address, telephone, fax, email) == 1;
	}

}
