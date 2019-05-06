import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';

import { Item } from './item';
import { ITEMS } from './mock-items';
import { MessageService } from './message.service';

@Injectable({providedIn: 'root'})
export class ItemService {

  constructor(private messageService: MessageService) { }

  getItems(): Observable<Item[]>{
    this.messageService.add('ItemService: fetched items');
    return of (ITEMS);
  }

  getItem(id: number): Observable<Item> {
    this.messageService.add(`ItemService: fetched item id=${id}`);
    return of(ITEMS.find(item => item.id === id));
  }
}
