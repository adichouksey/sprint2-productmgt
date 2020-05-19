package com.cap.greatoutdoor.productmgt.service;

import com.cap.greatoutdoor.productmgt.dao.IProductDao;
import com.cap.greatoutdoor.productmgt.entities.ProductDTO;
import com.cap.greatoutdoor.productmgt.exceptions.ProductNotFoundException;
import com.cap.greatoutdoor.productmgt.util.ProductValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao dao;

	/*
	 * to add products
	 * 
	 * @param product
	 * 
	 * @return product
	 */

	
	
	
	@Override
	public boolean addProduct(ProductDTO productdto) {
		
	String id=productdto.getProductId();
	ProductValidation.productValidation(id);
		productdto = dao.save(productdto);
		return true;
	}

	/*
	 * to find the Product by Id
	 * 
	 * @param productId
	 * 
	 * @return product
	 */

	public ProductDTO findProductById(String productId) {
		Optional<ProductDTO> optional = dao.findById(productId);
		if (optional.isPresent()) {
			ProductDTO productdto = optional.get();
			return productdto;
		}
		throw new ProductNotFoundException("Product not found for ProdcutId=" + productId);
	}
	/*
	 * to delete the Product by productId
	 * 
	 * @param prodcutId
	 * 
	 * @return boolean
	 */

	@Override
	public boolean deleteProduct(String productId) {
		Optional<ProductDTO> optional = dao.findById(productId);
		if (optional.isPresent()) {
			ProductDTO productdto = optional.get();
			dao.delete(productdto);
			return true;
		}
		throw new ProductNotFoundException("Product not found");
	}

	/*
	 * to Modify the Product details
	 * 
	 * @param product
	 * 
	 * @return modifiedProduct
	 */

	@Override
	public boolean modifyProduct(ProductDTO productdto) {

		boolean exists=dao.existsById(productdto.getProductId());
		if(exists){
		productdto = dao.save(productdto);
		return true;
		} throw new ProductNotFoundException("Product Not Found For these id"+productdto.getProductId());
	}

	/*
	 * to fetch all details of Product
	 * 
	 * @return list of all Products
	 */
	@Override
	public List<ProductDTO> fetchAllProducts() {
		List<ProductDTO> list = dao.findAll();
		return list;
	}
}
