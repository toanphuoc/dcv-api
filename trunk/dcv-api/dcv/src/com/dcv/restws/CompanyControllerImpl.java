package com.dcv.restws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcv.dto.Company;
import com.dcv.service.CompanyService;

@Controller
@WebService
@RequestMapping( value = "company")
public class CompanyControllerImpl implements CompanyController{

	@Autowired
	private CompanyService companyService;
	
	@Override
	@RequestMapping( value = "/getInfo", method = RequestMethod.GET, headers="Accept=application/json,text/html")
	@ResponseBody
	public Company getInfo() {
		return companyService.getInfo();
	}

}
