package com.cap.greatoutdoor.productmgt.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.greatoutdoor.productmgt.entities.Product;



public interface IProductDao extends JpaRepository<Product,String> {
	
}
