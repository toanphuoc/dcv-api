package com.dcv.restws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcv.model.Response;
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
	public Response login(@RequestParam(value="username") String userName,@RequestParam(value="password") String password) {
		return userService.login(userName, password);
	}

}
