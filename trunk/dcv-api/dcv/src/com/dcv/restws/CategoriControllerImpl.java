package com.dcv.restws;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dcv.dto.Category;
import com.dcv.service.CategoriService;

@Component
@WebService
@RequestMapping( value = "categories")
public class CategoriControllerImpl implements CategoriController {

	@Autowired
	private CategoriService categoriService;
	
	@Override
	@RequestMapping( value = "/getList", method = RequestMethod.GET, headers="Accept=application/json,text/html")
	@ResponseBody
	public List<Category> getAllCategories() {
		return categoriService.getAllCategories();
	}

	@Override
	@RequestMapping( value ="/getListOfTrademark/{trademarkId}", method = RequestMethod.GET, headers="Accept=application/json,text/html")
	@ResponseBody
	public List<Category> getCategorisByTrademark(@PathVariable("trademarkId") int trademarkId) {
		return categoriService.getCategoriesByTrademark(trademarkId);
	}

	@Override
	@RequestMapping( value = "/getCategoriById/{id}", method = RequestMethod.GET, headers="Accept=application/json,text/html")
	@ResponseBody
	public Category getCategoryById(@PathVariable("id") int id) {
		return categoriService.getCategoryById(id);
	}

}
