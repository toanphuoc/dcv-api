package com.dcv.restws;

import java.util.List;

import com.dcv.dto.Trademark;
import com.dcv.model.Response;

public interface TrademarkController {
	
	/**
	 * Get list trademark
	 * @author Nguyen Toan
	 * @return
	 */
	public List<Trademark> getListTrademark();
	
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
	public Response upddateTrademark(int id, String name, String description);
}
