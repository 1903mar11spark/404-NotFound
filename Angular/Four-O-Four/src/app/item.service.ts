import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';

import { Item } from './item';
import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'content-Type': 'application/json' })
};

@Injectable({providedIn: 'root'})
export class ItemService {

  constructor(
    private http: HttpClient, 
    private messageService: MessageService) { }

    private itemsUrl: string = 'https://29703770-e5ce-4f7a-b8c8-5a0b219cdb8c.mock.pstmn.io/getItems';

  getItems(): Observable<Item[]>{
    return this.http.get<Item[]>(`${this.itemsUrl}`);
  }

  getItem(id: number): Observable<Item> {
    const url = `${this.itemsUrl}/${id}`;
    return this.http.get<Item>(url).pipe(
      tap(_ => this.log(`fetched item id=${id}`)),
      catchError(this.handleError<Item>(`getItem id=${id}`))
    );
  }

  toggleCompleted(item:Item):Observable<any>{
    const url = `${this.itemsUrl}/${item.id}`;
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
