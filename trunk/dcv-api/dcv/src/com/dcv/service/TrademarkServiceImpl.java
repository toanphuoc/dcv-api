package com.dcv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcv.dao.TrademarkDao;
import com.dcv.dto.Trademark;
import com.dcv.model.Response;

public class TrademarkServiceImpl implements TrademarkService {

	@Autowired
	private TrademarkDao trademarkDao;
	
	@Override
	public List<Trademark> getListTrademarks() {
		return trademarkDao.getListTrademark();
	}

	@Override
	public Trademark getTrademarkById(int id) {
		return trademarkDao.getTrademarkById(id);
	}

	@Override
	public Response insertTrademark(String name, String description) {
		boolean rs = trademarkDao.insertTrademark(name, description);
		Response rp = new Response();
		if(rs){
			rp.setStatus(true);
			rp.setMessage("Insert successfully");
			rp.setData(null);
		}else{
			rp.setStatus(false);
			rp.setMessage("Insert fail");
			rp.setData(null);
		}
		return rp;
	}

	@Override
	public Response updateTrademark(int id, String name, String description) {
		boolean rs = trademarkDao.updaateTrademark(id, name, description);
		Response rp = new Response();
		if(rs){
			rp.setStatus(true);
			rp.setMessage("Update successfully");
			rp.setData(null);
		}else{
			rp.setStatus(false);
			rp.setMessage("Update fail");
			rp.setData(null);
		}
		return rp;
	}

}
