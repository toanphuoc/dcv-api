package com.dcv.restws;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.dcv.dto.ProductImage;
import com.dcv.service.ProductImageService;

public class ProductImageControllerImpl implements ProductImageController{

	@Autowired
	private ProductImageService productImageService;
	@Override
	public List<ProductImage> getProductImageOfProduct(int productId) {
		return productImageService.getProductImageOfProduct(productId);
	}

}
