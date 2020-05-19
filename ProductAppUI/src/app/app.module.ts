import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ListProductComponent } from './list-product/list-product.component';
import { ProductMgtComponent } from './product-mgt/product-mgt.component';

import { ProductService } from './services/productservice';
import { SearchProductComponent } from './search-product/search-product.component';
import { DeleteProductComponent } from './delete-product/delete-product.component';
import { ModifyProductComponent } from './modify-product/modify-product.component';
@NgModule({
  declarations: [
    AppComponent,
    AddProductComponent,
    ListProductComponent,
    ProductMgtComponent,
   
    SearchProductComponent,
   
    DeleteProductComponent,
   
    ModifyProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
    
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
