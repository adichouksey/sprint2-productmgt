import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/productservice';
import { Observable} from 'rxjs';
import { Product } from '../model/product';
@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrls: ['./search-product.component.css']
})
export class SearchProductComponent implements OnInit {

  service:ProductService
  constructor(service:ProductService) {
    this.service=service
   }


  ngOnInit(): void {
  }


  foundProduct=null;
foundStatus=null;

  findProduct(data:any):void
  {
    let details=data.value;
    let productId=details.productId;
    let fetched:Observable<Product> =this.service.findProductById(productId)
   fetched.subscribe(
    product=>{
    this.foundProduct=product;
    this.foundStatus="found";
     },
    err=>{
      this.foundStatus="notfound";
     console.log("err while fetching ="+err);  
     }
   );    

    }

}
