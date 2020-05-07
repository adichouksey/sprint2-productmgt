 package com.cap.greatoutdoor.productmgt.service;

import com.cap.greatoutdoor.productmgt.dao.IProductDao;
import com.cap.greatoutdoor.productmgt.entities.Product;
import com.cap.greatoutdoor.productmgt.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductDao dao;

    
    /*
     * to add products 
     * @param product
     * @return product 
     */
    
    @Override
    public Product addProduct(Product product){
        product=dao.save(product);
        return product;
    }

    
    /*
     * to find the Product by Id
     * @param productId
     * @return product
     */
    
    @Override
    public Product findProductById(String productId){
        Optional<Product> optional=dao.findById(productId);
        if(optional.isPresent()) {
            Product product=optional.get();
            return product;
        }
        throw new ProductNotFoundException("Product not found for ProdcutId="+productId);

    }
    
    /*
     * to delete the Product by productId
     * @param prodcutId
     * @return boolean
     */
    
    
    @Override
    public boolean deleteProduct(String productId)
    {
    	Optional<Product> optional=dao.findById(productId);
    	if(optional.isPresent()) {
    		Product product=optional.get();
    		dao.delete(product);
    		return true;
    	}
    	throw new ProductNotFoundException("Product not found");
    }

    
    /*
     * to Modify the Product details
     * @param product
     * @return modifiedProduct
     */
    
    
    @Override
    public Product modifyProduct(Product product)
    {
    	String productId=product.getProductId();
    	Optional<Product> optional=dao.findById(productId);
    	if(optional.isPresent()) {
    	Product product1=optional.get();
    	product1=dao.save(product);
        return product1;
    	}
    	throw new ProductNotFoundException("No Product is Modified");
    }
    
    
    /*
     * to fetch all details of Product
     * @return list of all Products
     */
    @Override
    public List<Product> fetchAllProducts() {
        List<Product> list=dao.findAll();
        return list;
    }
}
