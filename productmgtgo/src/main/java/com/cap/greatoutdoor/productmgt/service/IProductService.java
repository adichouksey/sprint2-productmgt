package com.cap.greatoutdoor.productmgt.service;


import java.util.List;

import com.cap.greatoutdoor.productmgt.entities.ProductDTO;

public interface IProductService {

    ProductDTO findProductById(String productId);

    ProductDTO addProduct(ProductDTO prodcut);

    List<ProductDTO>fetchAllProducts();
    
    boolean deleteProduct(String productId);
    
    ProductDTO modifyProduct(ProductDTO product);
}
