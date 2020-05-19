import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
@Injectable()
export class ProductService{
    client:HttpClient ;
  constructor(client:HttpClient ){
  this.client=client;
  }
  baseProductUrl="http://localhost:8088/products";

  addProduct(product:Product): Observable<Product>{
    let url=this.baseProductUrl+"/add";
    let result:Observable<Product>= this.client.post<Product>(url,product);
    return result;
    }
    
    
    fetchAllProducts():Observable<Product[]>
  {
    let url=this.baseProductUrl;
    let result:Observable<Product[]> =this.client.get<Product[]>(url);
    return result;
  }



  findProductById(productId:string):Observable<Product>{
    let url=this.baseProductUrl+'/get/'+productId;
    let observable:Observable<Product> =this.client.get<Product>(url);
    return observable;  
  }

  deleteProduct(productId:String){
    let url=this.baseProductUrl+"/delete/"+productId;
    let result:Observable<boolean>=this.client.delete<boolean>(url);
    return result;
  }

  modifyProduct(product:Product,productId:string):Observable<Product>{
    let url=this.baseProductUrl+"/modify/"+productId;
    console.log("product Id"+product.productId+ "product price"+product.productPrice+ "product color"+product.productColor
    + "product dimension"+product.productDimension+ "product Specificaiton"+product.productSpecification+ 
    "product manufacturer"+product.productManfucturer+ "quantity"+product.quantity+ "product category"+product.productCategory+
    "product name"+product.productName);
    let result:Observable<Product>= this.client.put<Product>(url,product);
    return result;
    }
  
}