package com.cap.greatoutdoor.productmgt.util;

import java.util.Map;

import com.cap.greatoutdoor.productmgt.entities.ProductDTO;

public class ProductUtil {

	public static ProductDTO convertToProductDTO(Map<String, Object> map) {

		String productId = (String) map.get("productId");
		double productPrice = (double) map.get("productPrice");
		String productColor = (String) map.get("productColor");
		String productDimension = (String) map.get("productDimension");
		String productSpecification = (String) map.get("productSpecification");
		String productManfucturer = (String) map.get("productManfucturer");
		int quantity = (int) map.get("quantity");
		int productCategory = (int) map.get("productCategory");
		String productName = (String) map.get("productName");

		ProductDTO productdto = new ProductDTO();
		
		productdto.setProductId(productId);
		productdto.setProductPrice(productPrice);
		productdto.setProductColor(productColor);
		productdto.setProductDimension(productDimension);
		productdto.setProductSpecification(productSpecification);
		productdto.setProductManfucturer(productManfucturer);
		productdto.setQuantity(quantity);
		productdto.setProductCategory(productCategory);
		productdto.setProductName(productName);

		return productdto;

	}
}
