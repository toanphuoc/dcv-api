package com.dcv.service;

import com.dcv.dto.Company;
import com.dcv.model.Response;

public interface CompanyService {

	/*
	 * Get info of company 
	 */
	public Company getInfo();
	
	/**
	 * 
	 * @param name
	 * @param address
	 * @param tel
	 * @param fax
	 * @param email
	 * @return
	 */
	public Response updateCompany(String name, String address, String tel, String fax, String email);
}
