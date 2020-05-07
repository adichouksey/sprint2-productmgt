package com.cap.greatoutdoor.productmgt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
   
    private String productId;
    private double productPrice;
    private String productColor;
    private String productDimension;
    private String productSpecification;
    private String productManfucturer;
    private int quantity;
    private int productCategory;
    private String productName;
   
    public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getProductDimension() {
		return productDimension;
	}

	public void setProductDimension(String productDimension) {
		this.productDimension = productDimension;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

	public String getProductManfucturer() {
		return productManfucturer;
	}

	public void setProductManfucturer(String productManfucturer) {
		this.productManfucturer = productManfucturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	
	
	/**
	 * To Check Equality of Product object
	 * @param object
	 * @return
	 */
	
	@Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !(object instanceof Product)) return false;
        Product product = (Product) object;
        return productId == product.productId;
    }

    
	/**
	 * Override Hascode
	 * @return hash
	 */
	
	@Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
