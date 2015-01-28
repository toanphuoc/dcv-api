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
	
	/**
	 * Insert access token
	 * @param userId
	 * @param accessToken
	 * @return
	 */
	public boolean insertAccessToken(int userId, String accessToken);
	
	/**
	 * update lasted login
	 * @param userId
	 * @return
	 */
	public boolean updateLastedLogin(int userId);
	
	/**
	 * Logout
	 * @param accessToken
	 * @return
	 */
	public boolean logout(String accessToken);
	
}
