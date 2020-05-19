package com.cap.greatoutdoor.productmgt.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hsqldb.persist.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.greatoutdoor.productmgt.entities.ProductDTO;
import com.cap.greatoutdoor.productmgt.entities.ProductDTO;
import com.cap.greatoutdoor.productmgt.exceptions.ProductNotFoundException;
import com.cap.greatoutdoor.productmgt.service.IProductService;
import com.cap.greatoutdoor.productmgt.util.ProductUtil;

@RestController
@RequestMapping("/products")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private IProductService productservice;

	/**
	 * 
	 * @return list of products
	 */

	@GetMapping
	public ResponseEntity<List<ProductDTO>> fetchAllProducts() {
		List<ProductDTO> productlist = productservice.fetchAllProducts();

		ResponseEntity<List<ProductDTO>> response = new ResponseEntity<>(productlist, HttpStatus.OK);
		return response;
	}

	/**
	 * for adding the details of Product
	 * 
	 * @param requestDto
	 * @return
	 */

	@PostMapping("/add")
	public ResponseEntity<Object> addProduct(@RequestBody Map<String, Object> requestdata) {
		
		ProductDTO productdto = ProductUtil.convertToProductDTO(requestdata);
		boolean result = productservice.addProduct(productdto);
		ResponseEntity<Object> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	/**
	 * for modifying the details of products
	 * 
	 * @param productId
	 * @param requestDto
	 * @return
	 */

	@PutMapping("/modify/{productId}")
	public ResponseEntity<Object> modifyProduct(@RequestBody Map<String, Object> requestdata,@PathVariable("productId") String productId) {
			ProductDTO productdto=productservice.findProductById(productId);
		ProductDTO productdtos = ProductUtil.convertToProductDTO(requestdata);
		boolean result = productservice.modifyProduct(productdtos);
		ResponseEntity<Object> response = new ResponseEntity<>(productdto, HttpStatus.OK);
		return response;
	}

	/**
	 * to get the details about the Product by productId
	 * 
	 * @param productId
	 * @return
	 */
	@GetMapping("/get/{productId}")
	public ResponseEntity<ProductDTO> findProductById(@PathVariable("productId") String productId) {
		ProductDTO productdto = productservice.findProductById(productId);

		ResponseEntity<ProductDTO> response = new ResponseEntity<>(productdto, HttpStatus.OK);
		return response;
	}

	/**
	 * to delete the Product by productId
	 * 
	 * @param productId
	 * @return
	 */

	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("productId") String productId) {
		
		boolean result = productservice.deleteProduct(productId);
		ResponseEntity<Boolean> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex) {
		log.error("Invalid productId Exception" + ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity(msg, HttpStatus.NOT_FOUND);
		return response;

	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleAll (Throwable ex){
		log.error("Something went Wrong",ex);
		String msg="Something went Wrong";
		ResponseEntity<String> response=new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}

}