package com.dcv.service;

import java.util.List;

import com.dcv.dto.Trademark;
import com.dcv.model.Response;

public interface TrademarkService {

	/**
	 * @author Nguyen Toan
	 * Get list trademark
	 * @return
	 */
	public List<Trademark> getListTrademarks();

	/**
	 * Get trademark by id
	 * @author Nguyen Toan
	 * @param id
	 * @return
	 */
	public Trademark getTrademarkById(int id);
	
	/**
	 * add new trademark
	 * @param id
	 * @param name
	 * @param description
	 * @return
	 */
	public Response insertTrademark(String name, String description);
	
	/**
	 * Update trademark
	 * @param id
	 * @param name
	 * @param description
	 * @return
	 */
	public Response updateTrademark(int id, String name, String description);
}
