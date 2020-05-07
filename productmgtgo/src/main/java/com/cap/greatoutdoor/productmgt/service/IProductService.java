package com.cap.greatoutdoor.productmgt.service;


import java.util.List;

import com.cap.greatoutdoor.productmgt.entities.Product;

public interface IProductService {

    Product findProductById(String productId);

    Product addProduct(Product prodcut);

    List<Product>fetchAllProducts();
    
    boolean deleteProduct(String productId);
    
    Product modifyProduct(Product product);
}
