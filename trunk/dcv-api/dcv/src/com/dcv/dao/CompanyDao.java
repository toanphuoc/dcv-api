package com.dcv.dao;

import com.dcv.dto.Company;

public interface CompanyDao {

	/**
	 * Get info of company
	 * @return
	 */
	public Company getInfo();
	
	/**
	 * Update company infomation
	 * @param name
	 * @param address
	 * @param telephone
	 * @param fax
	 * @param email
	 * @return
	 */
	public boolean updateCompany(String name, String address, String telephone, String fax, String email);
}
