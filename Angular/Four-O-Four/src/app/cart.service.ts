import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';

import { Item } from './item';
import { ItemC } from './itemCreation';
import { CartItem } from './cartItem';
import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'content-Type': 'application/json' })
};

@Injectable({providedIn: 'root'})
export class CartService {


  constructor( private http: HttpClient, 
    private messageService: MessageService) { }
    private getCartUrl: string = 'http://localhost:8084/404NotFound2/carts';

    getCarts(userId: number): Observable<CartItem[]>{
      return this.http.get<CartItem[]>(`${this.getCartUrl}/${userId}`);
    }




}
