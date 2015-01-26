package com.dcv.restws;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcv.dto.ProductImage;
import com.dcv.service.ProductImageService;

@Controller
@WebService
@RequestMapping(value = "image")
public class ProductImageControllerImpl implements ProductImageController{

	@Autowired
	private ProductImageService productImageService;
	
	@Override
	@RequestMapping(value = "/lstImage/{productId}", method=RequestMethod.GET)
	@ResponseBody
	public List<ProductImage> getProductImageOfProduct(@PathVariable("productId") int productId) {
		return productImageService.getProductImageOfProduct(productId);
	}

}
