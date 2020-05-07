package com.cap.greatoutdoor.productmgt.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String msg){
        super(msg);
    }
}
