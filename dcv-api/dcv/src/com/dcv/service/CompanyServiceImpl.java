package com.dcv.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcv.dao.CompanyDao;
import com.dcv.dto.Company;
import com.dcv.model.Response;

public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public Company getInfo() {
		return companyDao.getInfo();
	}

	@Override
	public Response updateCompany(String name, String address, String tel,
			String fax, String email) {
		boolean rs = companyDao.updateCompany(name, address, tel, fax, email);
		Response rp = new Response();
		if(rs){
			rp.setStatus(true);
			rp.setMessage("Update successfully");
		}else{
			rp.setStatus(false);
			rp.setMessage("Update fail");
		}
		return rp;
	}

}
