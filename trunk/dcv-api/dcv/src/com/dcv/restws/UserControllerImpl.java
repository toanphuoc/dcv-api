package com.dcv.restws;

import java.util.Map;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dcv.service.UserService;

@Controller
@WebService
@RequestMapping(value = "user")
public class UserControllerImpl implements UserController{

	@Autowired
	private UserService userService;
	
	@Override
	@RequestMapping( value = "/login", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestParam(value="username") String userName,
						@RequestParam(value="password") String password) {
//		String id = requestContext.getRemoteAddr().toString();
		return userService.login(userName, password);
	}

}
