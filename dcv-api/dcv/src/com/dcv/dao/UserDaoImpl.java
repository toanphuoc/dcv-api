package com.dcv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.dcv.dto.User;
import com.dcv.until.ConnectionManager;

public class UserDaoImpl extends ConnectionManager implements UserDao{
	
	@Override
	public User login(String userName, String password) {
		String sql = "CALL getUserByUserNameAndPassword(?, ?)";
		RowMapper<User> mapper = new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
//				user.setPassword(rs.getString("password"));
				return user;
			}
		};
		List<User> users = jdbcTemplate.query(sql, mapper, userName, password);
		if(users.size() > 0 && users.size() < 2)
			return users.get(0);
		return null;
	}

	@Override
	public boolean insertAccessToken(int userId, String accessToken) {
		String sql = "CALL insertAccessToken(?, ?)";
		return jdbcTemplate.update(sql, userId, accessToken) == 1;
	}

	@Override
	public boolean updateLastedLogin(int userId) {
		String sql = "CALL updateLastedLogin(?)";
		return jdbcTemplate.update(sql, userId) == 1;
	}

	@Override
	public boolean logout(String accessToken) {
		String sql = "CALL deleteAccessToken(?)";
		return jdbcTemplate.update(sql, accessToken) == 1;
	}

	@Override
	public User getUserByAccessToken(String accessToken) {
		String sql = "CALL getUserByAccessToken(?)";
		RowMapper<User> mapper = new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		};
		List<User> users = jdbcTemplate.query(sql, mapper, accessToken);
		if(users.size() > 0 && users.size() < 2)
			return users.get(0);
		return null;
	}

	@Override
	public boolean changePassword(int userId, String newPassword) {
		String sql = "CALL changePassword(?, ?)";
		return jdbcTemplate.update(sql, userId, newPassword) == 1;
	}

}
