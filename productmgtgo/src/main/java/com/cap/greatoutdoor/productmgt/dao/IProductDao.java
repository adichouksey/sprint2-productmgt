package com.cap.greatoutdoor.productmgt.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.greatoutdoor.productmgt.entities.ProductDTO;



public interface IProductDao extends JpaRepository<ProductDTO,String> {
	
}
