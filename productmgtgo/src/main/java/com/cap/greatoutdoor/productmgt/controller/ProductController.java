package com.cap.greatoutdoor.productmgt.controller;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

import com.cap.greatoutdoor.productmgt.entities.Product;
import com.cap.greatoutdoor.productmgt.entities.ProductDTO;
import com.cap.greatoutdoor.productmgt.exceptions.ProductNotFoundException;
import com.cap.greatoutdoor.productmgt.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	
	private static final Logger log=LoggerFactory.getLogger(ProductController.class);
    
	
	@Autowired
    private IProductService productservice;

	
	/**
	 * 
	 * @return list of products
	 */
	
    @GetMapping
    public ResponseEntity<List<ProductDTO>> fetchAllProducts() {
        List<Product> productlist = productservice.fetchAllProducts();
        List<ProductDTO> productdtolist=convertToDTO(productlist);
         ResponseEntity<List<ProductDTO>>response=new ResponseEntity<>(productdtolist,HttpStatus.OK);
        return response;
    }

    
    /**
     * for adding the details of Product 
     * @param requestDto
     * @return
     */
    
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO requestDto) {
        Product product = convertToProduct(requestDto);
        product = productservice.addProduct(product);
       ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);
        return response;
    }
    
    /**
     * for modifying the details of products
     * @param productId
     * @param requestDto
     * @return
     */
    
    @PutMapping("/modify/{productId}")
    public ResponseEntity<ProductDTO> modifyProduct(@PathVariable("productId") String productId, @RequestBody ProductDTO requestDto)
    {
    	Product product=productservice.findProductById(productId);
    	product.setProductId(productId);
    	product.setProductPrice(requestDto.getProductPrice());
        product.setProductCategory(requestDto.getProductCategory());
        product.setProductColor(requestDto.getProductColor());
        product.setProductDimension(requestDto.getProductDimension());
        product.setProductManfucturer(requestDto.getProductManfucturer());
        product.setProductName(requestDto.getProductName());
        product.setProductSpecification(requestDto.getProductSpecification());
        product.setQuantity(requestDto.getQuantity());
         product=productservice.modifyProduct(product);
         ProductDTO productdto=convertToDTO(product);
         ResponseEntity<ProductDTO> response=new ResponseEntity<>(productdto,HttpStatus.OK);
    	return response;
    }
/**
 * to get the details about the Product by productId
 * @param productId
 * @return
 */
    @GetMapping("/get/{productId}")
    public ResponseEntity<ProductDTO>findProductById(@PathVariable("productId") String productId){
       Product product= productservice.findProductById(productId);
       ProductDTO dto=convertToDTO(product);
       ResponseEntity<ProductDTO>response=new ResponseEntity<>(dto,HttpStatus.OK);
       return response;
    }
    
    
    
    /**
     * to delete the Product by productId
     * @param productId
     * @return
     */
    
    @DeleteMapping("/delete/{productId}")
    	public ResponseEntity<Boolean> deleteProduct(@PathVariable("productId") String productId)
    		{
    			boolean result=productservice.deleteProduct(productId);
    			ResponseEntity<Boolean> response=new ResponseEntity<>(result,HttpStatus.OK);
    			return response;
    		}
    	
    public List<ProductDTO> convertToDTO(Collection<Product> productlist){
    	List<ProductDTO> dtos=new ArrayList();
    	for(Product product: productlist)
    	{
    		ProductDTO productdto=convertToDTO(product);
    		dtos.add(productdto);
    	}
    	return dtos;
    }
    
    
    
public ProductDTO convertToDTO(Product product)
{
	ProductDTO productdto= new ProductDTO();
	productdto.setProductId(product.getProductId());
	productdto.setProductName(product.getProductName());
	productdto.setProductCategory(product.getProductCategory());
	productdto.setProductColor(product.getProductColor());
	productdto.setProductDimension(product.getProductDimension());
	productdto.setProductManfucturer(product.getProductManfucturer());
	productdto.setProductPrice(product.getProductPrice());
	productdto.setProductSpecification(product.getProductDimension());
	productdto.setQuantity(product.getQuantity());
    return productdto;
}


public List<Product> convertToProduct(Collection<ProductDTO> productdtolist){
List<Product> products=new ArrayList();
for(ProductDTO productdto: productdtolist)
{
	Product product=convertToProduct(productdto);
	products.add(product);
}
return products;
}




public Product convertToProduct(ProductDTO productdto)
{
	Product product=new Product();
	 product.setProductId(productdto.getProductId());
     product.setProductPrice(productdto.getProductPrice());
     product.setProductCategory(productdto.getProductCategory());
     product.setProductColor(productdto.getProductColor());
     product.setProductDimension(productdto.getProductDimension());
     product.setProductManfucturer(productdto.getProductManfucturer());
     product.setProductName(productdto.getProductName());
     product.setProductSpecification(productdto.getProductSpecification());
     product.setQuantity(productdto.getQuantity());
    return product;
}

@ExceptionHandler(ProductNotFoundException.class)
public ResponseEntity<String>handleProductNotFound(ProductNotFoundException ex)
{
	log.error("Invalid productId Exception"+ex);
	String msg=ex.getMessage();
	ResponseEntity<String> response =new ResponseEntity(msg,HttpStatus.NOT_FOUND);
	return response;
	
}

}