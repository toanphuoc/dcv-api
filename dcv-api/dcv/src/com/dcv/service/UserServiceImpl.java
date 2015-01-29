package com.dcv.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcv.dao.UserDao;
import com.dcv.dto.User;
import com.dcv.model.Response;
import com.dcv.security.Security;
import com.dcv.until.Base64Utils;
import com.dcv.until.DcvContanst;
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
			accessToken = Base64Utils.encode(String.valueOf(user.getId())
					+ StringUtil.randomString(DcvContanst.LENGTHACCESSTOKEN));
			if(!userDao.insertAccessToken(user.getId(), accessToken)){
				accessToken = null;
				return resultLogin(false, accessToken, null, user);
			}
			userDao.updateLastedLogin(user.getId());
			return resultLogin(true, accessToken, "Login successfully", user);
		}
	}
	
	private Map<String, Object> resultLogin(boolean success, String accessToken, String message, User user){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", success);
		map.put("access_token", accessToken);
		map.put("message", message);
		map.put("clientAccess", true);
		if(success && user != null){
			user.setId(Integer.MIN_VALUE);
			map.put("user", user);
		}
			
		return map;
	}

	@Override
	public Response logout(String accessToken) {
		boolean rs = userDao.logout(accessToken);
		Response rp = new Response();
		if(rs){
			rp.setStatus(true);
			rp.setMessage("Logout successfully");
		}else{
			rp.setStatus(false);
			rp.setMessage("Access token invalid");
		}
		return rp;
	}

	@Override
	public Map<String, Object> changePassword(String accessToken, String oldPassword, String newPassword) {
		User user = userDao.getUserByAccessToken(accessToken);
		Map<String, Object> map  = new HashMap<String, Object>();
		if(user  != null){
			if(!user.getPassword().equals(Security.encrypSHA256(oldPassword))){
				map.put("result", 2);
				map.put("message", "Old password incorrecct");
			}else{
				boolean rs = userDao.changePassword(user.getId(), Security.encrypSHA256(newPassword));
				if(rs){
					map.put("result", 0);
					map.put("message", "Change success");
				}else{
					map.put("result", 3);
					map.put("message", "Change fail");
				}
			}
		}else{
			map.put("result", 1);
			map.put("message", "Invalid token");
		}
		return map;
	}

	
}
