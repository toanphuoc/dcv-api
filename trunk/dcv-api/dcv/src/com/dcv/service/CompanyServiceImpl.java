package com.dcv.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcv.dao.CompanyDao;
import com.dcv.dto.Company;

public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public Company getInfo() {
		return companyDao.getInfo();
	}

}
