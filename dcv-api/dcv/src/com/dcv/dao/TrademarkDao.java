package com.dcv.dao;

import java.util.List;

import com.dcv.dto.Trademark;

public interface TrademarkDao {
	
	/**
	 * Get list trademark
	 * @return
	 */
	public List<Trademark> getListTrademark();
	
	/**
	 * Get trademark by id
	 * @param id
	 * @return
	 */
	public Trademark getTrademarkById(int id);
	
	/**
	 * Add new trademark
	 * @param id
	 * @param name
	 * @param description
	 * @return
	 */
	public boolean insertTrademark(String name, String description);
	
	/**
	 * Update trademark
	 * @param id
	 * @param name
	 * @param description
	 * @return
	 */
	public boolean updaateTrademark(int id, String name, String description);
}
