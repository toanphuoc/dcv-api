package com.dcv.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcv.dao.UserDao;
import com.dcv.dto.User;
import com.dcv.security.Security;
import com.dcv.until.Base64Utils;
import com.dcv.until.StringUtil;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public Map<String, Object> login(String userName, String password) {
		password = Security.encrypSHA256(password);
		String accessToken = null;
		User user = userDao.login(userName, password);
		if(user == null){
			return resultLogin(false, accessToken, null, user);
		}else{
			accessToken = Base64Utils.encode(String.valueOf(user.getId()))
					+ StringUtil.randomString(10);
			if(!userDao.insertAccessToken(user.getId(), accessToken)){
				accessToken = null;
				return resultLogin(false, accessToken, null, user);
			}
			userDao.updateLastedLogin(user.getId());
			return resultLogin(true, accessToken, "", user);
		}
	}
	
	private Map<String, Object> resultLogin(boolean success, String accessToken, String message, User user){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", success);
		map.put("accessToken", accessToken);
		map.put("message", message);
		map.put("clientAccess", true);
		return map;
	}

	
}
