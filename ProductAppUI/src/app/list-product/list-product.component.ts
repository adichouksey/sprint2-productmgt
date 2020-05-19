import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import {ProductService} from '../services/productservice';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {


  ngOnInit(): void {
  }



  products:Product[]=[];

  service:ProductService;

  orderByField:string=null;

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



} 
