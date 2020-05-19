import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/productservice';
import { Product } from '../model/product';

@Component({
  selector: 'app-modify-product',
  templateUrl: './modify-product.component.html',
  styleUrls: ['./modify-product.component.css']
})
export class ModifyProductComponent implements OnInit {
  service:ProductService;
  constructor(service:ProductService) {
    this.service=service;
   }

  ngOnInit(): void {
  }

  modifiedProduct:Product=null;

  modifyProduct(data:any)
  {
    let details=data.value;
    let productId=details.productId;
  let  productPrice=details.productPrice;
  let productColor=details.productColor;
  let productDimension=details.productDimension;
  let productSpecification=details.productSpecification;
  let productManfucturer=details.productManfucturer;
  let quantity=details.quantity;
  let productCategory=details.productCategory;
  let productName=details.productName;

  this.modifiedProduct=new Product();

  
this.modifiedProduct.productId=productId;
this.modifiedProduct.productPrice=productPrice;
this.modifiedProduct.productColor=productColor;
this.modifiedProduct.productDimension=productDimension;
this.modifiedProduct.productSpecification=productSpecification;
this.modifiedProduct.productManfucturer=productManfucturer;
this.modifiedProduct.quantity=quantity;
this.modifiedProduct.productCategory=productCategory;
this.modifiedProduct.productName=productName;


let result=this.service.modifyProduct(this.modifiedProduct,productId) // adding to the store
    result.subscribe((product:Product)=>{
      
    },
    err=>{
    console.log("err="+err);
    } );
    data.reset();
}

}
