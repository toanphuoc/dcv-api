package com.dcv.service;

import java.util.Map;

import com.dcv.dto.User;

public interface UserService {

	/**
	 * Login
	 * @param userName
	 * @param password
	 * @return
	 */
	public Map<String, Object> login(String userName, String password);
}
