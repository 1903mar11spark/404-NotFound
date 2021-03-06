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
export class ItemService {

  constructor(
    private http: HttpClient, 
    private messageService: MessageService) { }

    private itemsUrl: string = 'http://localhost:8084/404NotFound2/items/all';
    private itemType: string = 'http://localhost:8084/404NotFound2/items/type';
    private itemName: string = 'http://localhost:8084/404NotFound2/items/itemName';
    private itemIdUrl: string = 'http://localhost:8084/404NotFound2/items';
    private itemAUrl: string = 'http://localhost:8084/404NotFound2/items';
    private itemCondition: string = 'http://localhost:8084/404NotFound2/items/condition';
    private itemPrice: string = 'http://localhost:8084/404NotFound2/items/price';

    private cartUrl: string = 'http://localhost:8084/404NotFound2/carts';
   

  getItems(): Observable<Item[]>{
    return this.http.get<Item[]>(`${this.itemsUrl}`);
  }

  getItem(id: number): Observable<Item> {
    const url = `${this.itemIdUrl}/${id}`;
    return this.http.get<Item>(url).pipe(
      tap(_ => this.log(`fetched item id=${id}`)),
      catchError(this.handleError<Item>(`getItem id=${id}`))
    );
  }

  getItemName(name: string): Observable<Item>{
    const urlN = `${this.itemName}/${name}`;
    return this.http.get<Item>(urlN).pipe(
      tap(_ => this.log(`fetched item id=${name}`)),
      catchError(this.handleError<Item>(`getItem id=${name}`))
    );
  }

  getItemByType(type: number): Observable<Item[]>{
    const urlT = `${this.itemType}/${type}`;
    return this.http.get<Item[]>(urlT).pipe(
      tap(_ => this.log(`fetched item id=${type}`)),
      catchError(this.handleError<Item[]>(`getItem id=${type}`))
    );
  }

  getItemByCondition(condition: boolean): Observable<Item[]>{
    const urlC = `${this.itemCondition}/${condition}`;
    return this.http.get<Item[]>(urlC).pipe(
      tap(_ => this.log(`fetched item id=${condition}`)),
      catchError(this.handleError<Item[]>(`getItem id=${condition}`))
    );
  }

  getItemByPrice(price: number, price2: number): Observable<Item[]>{
    const urlP = `${this.itemPrice}/${price}/ ${price2}`;
    return this.http.get<Item[]>(urlP).pipe(
      tap(_ => this.log(`fetched item id=${price}/ ${price2}`)),
      catchError(this.handleError<Item[]>(`getItem id=${price}/ ${price2}`))
    );
  }

  addListing (item: ItemC): Observable<ItemC> {
    return this.http.post<any>(`${this.itemAUrl}`,item);
  }

  addCart(cartI: CartItem): Observable<CartItem> {
    return this.http.post<any>(`${this.cartUrl}`,cartI);
  }


  toggleCompleted(item:Item):Observable<any>{
    const url = `${this.itemsUrl}/${item.itemName}`;
    return this.http.put(url, item, httpOptions);
  }
  
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
 
  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`itemService: ${message}`);
  }
}
