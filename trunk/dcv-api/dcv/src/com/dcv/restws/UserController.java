package com.dcv.restws;

import com.dcv.model.Response;

public interface UserController {

	/**
	 * login
	 * @param userName
	 * @param password
	 * @return
	 */
	public Response login(String userName, String password);
}
