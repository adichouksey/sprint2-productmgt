import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductMgtComponent } from './product-mgt/product-mgt.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ListProductComponent } from './list-product/list-product.component';
import { SearchProductComponent } from './search-product/search-product.component';
import { DeleteProductComponent } from './delete-product/delete-product.component';
import { ModifyProductComponent } from './modify-product/modify-product.component';


const routes: Routes = [
  {
    path:'product-mgt',
    component:ProductMgtComponent
  },
  {
    path:'add-product',
    component:AddProductComponent
  },
{
  path:'list-product',
  component:ListProductComponent
}
,
{
  path:'search-product',
  component:SearchProductComponent
},
{
  path:'delete-product',
  component:DeleteProductComponent
},
{
  path:'modify-product',
  component:ModifyProductComponent
}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
