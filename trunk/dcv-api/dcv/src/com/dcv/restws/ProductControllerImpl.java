package com.dcv.restws;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcv.dto.Product;
import com.dcv.service.ProductService;

@Controller
@WebService
@RequestMapping( value = "product")
public class ProductControllerImpl implements ProductController {

	@Autowired
	private ProductService productService;
	
	@Override
	@RequestMapping(value = "/productByTrademark/{trademarkId}", method=RequestMethod.GET, headers="Accept=application/json,text/html")
	@ResponseBody
	public List<Product> getProductsByTrademark(@PathVariable("trademarkId") int trademarkId) {
		return productService.getProductsByTrademark(trademarkId);
	}

	@Override
	@RequestMapping( value="/productByCategory/{categoriId}", method=RequestMethod.GET, headers="Accept=application/json,text/html")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable("categoriId") int categoriId) {
		return productService.getProductsByCategory(categoriId);
	}

	@Override
	@RequestMapping( value = "/topTenNewProduct", method = RequestMethod.GET, headers="Accept=application/json,text/html")
	@ResponseBody
	public List<Product> getTopTenNewProduct() {
		return productService.getTopTenNewProduct();
	}

	@Override
	@RequestMapping(value = "/productById/{id}", method = RequestMethod.GET, headers="Accept=application/json,text/html")
	@ResponseBody
	public Product getProductById(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}

}
