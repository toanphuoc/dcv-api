package com.dcv.restws;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcv.dto.Trademark;
import com.dcv.model.Response;
import com.dcv.service.TrademarkService;

@Component
@WebService
@RequestMapping( value = "trademark")
public class TrademarkControllerImpl implements TrademarkController{

	@Autowired
	private TrademarkService trademarkService;
	
	@Override
	@RequestMapping( value = "/getList", method = RequestMethod.GET, headers="Accept=application/json,text/html")
	@ResponseBody
	public List<Trademark> getListTrademark() {
		return trademarkService.getListTrademarks();
	}

	@Override
	@RequestMapping( value = "/getTrademarkById/{id}", method = RequestMethod.GET, headers="Accept=application/json,text/html")
	@ResponseBody
	public Trademark getTrademarkById(@PathVariable("id") int id) {
		return trademarkService.getTrademarkById(id);
	}

	@Override
	@RequestMapping( value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Response insertTrademark(@RequestParam(value="name", required=false) String name, @RequestParam(value="description", required=false) String description) {
		return trademarkService.insertTrademark(name, description);
	}

	@Override
	@RequestMapping( value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Response upddateTrademark(@RequestParam(value="id", required=true) int id, @RequestParam(value="name", required=false) String name,@RequestParam(value="description", required=false) String description) {
		return trademarkService.updateTrademark(id, name, description);
	}

}
