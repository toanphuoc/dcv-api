package com.dcv.restws;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dcv.dto.User;
import com.dcv.model.Response;

public interface UserController {

	/**
	 * login
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
	 * 
	 * @param accessToken
	 * @param oldPass
	 * @param newPass
	 * @return
	 */
	public Map<String , Object> changePassword(String accessToken, String oldPass, String newPass);
}
