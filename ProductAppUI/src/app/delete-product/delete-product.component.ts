import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/productservice';
import { Product } from '../model/product';
import {Observable} from 'rxjs'
import{ Router} from '@angular/router';

@Component({
  selector: 'app-delete-product',
  templateUrl: './delete-product.component.html',
  styleUrls: ['./delete-product.component.css']
})
export class DeleteProductComponent implements OnInit {

  products:Product[]=[];
  ngOnInit(): void {
  }

  service:ProductService;
  constructor(service:ProductService,private router:Router) {
  
    this.service=service;

    let observable:Observable<Product[]>=this.service.fetchAllProducts();
    observable.subscribe(
      product=>{
        this.products=product;
        console.log("inside success callback ="+this.products.length);
      },
      err=>console.log(err)
      );
  }

  removeProduct(productId:string)
  {
 let result:Observable<boolean>=this.service.deleteProduct(productId);
 result.subscribe(product=>{
     this.removeLocalProduct(productId);
 },err=>{
  console.log("err in deleting ="+err);
 })   
}



removeLocalProduct(productId:string)
{
let foundIndex=-1;
for(let i=0;i<this.products.length;i++){
 let product=this.products[i];
 if(product.productId===productId){
   foundIndex=i;
   break;
 }
}
if(foundIndex<0){
 return;
}
this.products.splice(foundIndex,1);
}
}
