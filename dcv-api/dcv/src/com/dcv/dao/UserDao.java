package com.dcv.dao;

import com.dcv.dto.User;

public interface UserDao {

	/**
	 * Login
	 * @param userName
	 * @param password
	 * @return
	 */
	public User login(String userName, String password);
}
