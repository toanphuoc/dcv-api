package com.dcv.dao;

import com.dcv.dto.Company;

public class CompanyDaoImpl implements CompanyDao{

	@Override
	public Company getInfo() {
		return new Company("Cong ty TNHH Noi that Dai Co Viet", "234 Nguyen Trai, Phuong 5, Quan 6, TP Ho Chi Minh", "0123 213 1321", "083 1231 312", "noithatdcv@gmail.com");
	}

}
