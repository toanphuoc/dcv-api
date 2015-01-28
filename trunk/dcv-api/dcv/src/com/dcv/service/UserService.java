package com.dcv.service;

import com.dcv.model.Response;

public interface UserService {

	/**
	 * Login
	 * @param userName
	 * @param password
	 * @return
	 */
	public Response login(String userName, String password);
}
