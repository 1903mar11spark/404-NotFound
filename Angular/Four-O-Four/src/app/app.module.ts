import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ItemDetailComponent } from './item-detail/item-detail.component';
import { ItemsComponent } from './items/items.component';
import { MessagesComponent } from './messages/messages.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { CartComponent } from './cart/cart.component';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],

  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    ItemsComponent,
    ItemDetailComponent,
    MessagesComponent,
    UserInfoComponent,
    CartComponent
  ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
