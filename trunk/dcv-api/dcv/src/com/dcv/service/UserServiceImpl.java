package com.dcv.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcv.dao.UserDao;
import com.dcv.dto.User;
import com.dcv.model.Response;
import com.dcv.security.Security;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public Response login(String userName, String password) {
		password = Security.encrypSHA256(password);
		User user = userDao.login(userName, password);
		Response rp = new Response();
		if(user == null){
			rp.setStatus(false);
			rp.setMessage("Tên đăng nhập hoặc mật khẩu không chính xác");
		}else{
			rp.setStatus(true);
			rp.setMessage("Login successfully");
			rp.setData(user);
		}
		return rp;
	}

	
}
