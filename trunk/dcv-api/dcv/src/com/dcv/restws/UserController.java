package com.dcv.restws;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dcv.dto.User;

public interface UserController {

	/**
	 * login
	 * @param userName
	 * @param password
	 * @return
	 */
	public Map<String, Object> login(String userName, String password);
}
