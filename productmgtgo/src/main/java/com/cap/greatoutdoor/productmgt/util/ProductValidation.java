package com.cap.greatoutdoor.productmgt.util;

import com.cap.greatoutdoor.productmgt.entities.ProductDTO;
import com.cap.greatoutdoor.productmgt.exceptions.ProductNotFoundException;

public class ProductValidation {

	
	public static boolean  productValidation(String productId) {
		
		// To do the Validation
		
		boolean flag = productId.matches("\\D\\w+");
		if (!flag) {
			throw new ProductNotFoundException("Id Should Start with String");
		}
		return true;
	}
}
