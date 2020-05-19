import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/productservice';
import { Product } from '../model/product';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {


  service:ProductService;
  constructor(service:ProductService) {
    this.service=service;
   }
   ngOnInit(): void {
  }

   addedProduct:Product=null;

   addProduct(data:any)
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

this.addedProduct= new Product();

this.addedProduct.productId=productId;
this.addedProduct.productPrice=productPrice;
this.addedProduct.productColor=productColor;
this.addedProduct.productDimension=productDimension;
this.addedProduct.productSpecification=productSpecification;
this.addedProduct.productManfucturer=productManfucturer;
this.addedProduct.quantity=quantity;
this.addedProduct.productCategory=productCategory;
this.addedProduct.productName=productName;


let result=this.service.addProduct(this.addedProduct); // adding to the store
result.subscribe((product:Product)=>{
  this.addedProduct=product;
},
err=>{
console.log("err="+err);
} );
data.reset();

}


}

