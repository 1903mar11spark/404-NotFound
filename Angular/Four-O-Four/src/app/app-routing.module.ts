import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { ItemsComponent} from './items';
import { ItemDetailComponent} from './item-detail/item-detail.component';
import { UserInfoComponent} from './user-info';
import { CartComponent } from './cart';
import { SellComponent } from './sell';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'items', component: ItemsComponent },
  { path: 'detail/:id/:price', component: ItemDetailComponent },
  { path: 'user', component: UserInfoComponent },
  { path: 'cart', component: CartComponent },
  { path: 'sell', component: SellComponent },
   // otherwise redirect to home
   { path: '**', redirectTo: '' }
];

export const appRoutingModule = RouterModule.forRoot(routes);

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
