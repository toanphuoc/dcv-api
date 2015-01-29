package com.dcv.service;

import java.util.Map;

import com.dcv.dto.User;
import com.dcv.model.Response;

public interface UserService {

	/**
	 * Login
	 * @param userName
	 * @param password
	 * @return
	 */
	public Map<String, Object> login(String userName, String password);
	
	/**
	 * 
	 * @param accessToken
	 * @return
	 */
	public Response logout(String accessToken);
	
	/**
	 * Change password
	 * @param accessToken
	 * @return
	 */
	public Map<String, Object> changePassword(String accessToken, String oldPassword, String newPassword);
}
