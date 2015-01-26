package com.dcv.restws;

import com.dcv.dto.Company;
import com.dcv.model.Response;

public interface CompanyController {

	/**
	 * 
	 * @return
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
