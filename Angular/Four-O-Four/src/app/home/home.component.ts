import { Component, OnInit, Input} from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

import { Item } from '../item';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: [ './home.component.css' ]
})

export class HomeComponent implements OnInit {
  @Input() item: Item;
  items: Item[] = [];
  items$: Observable<Item>;
  private searchTerms = new Subject<string>();

  search(term: string): void {
    this.searchTerms.next(term);
  }

  constructor(private itemService: ItemService) { }
 
  ngOnInit() {
    this.getItems();
    this.items$ = this.searchTerms.pipe(
      debounceTime(300),
    distinctUntilChanged(),
    switchMap((term: string) => this.itemService.getItemName(term)), );
  }

  byVideogame(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByType(1)
        .subscribe(item => this.item = item);
   }
  }

  byComputer(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByType(2)
        .subscribe(item => this.item = item);
   }
  }

  byAccesories(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByType(3)
        .subscribe(item => this.item = item);
   }
  }

  byNew(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByCondition(true)
        .subscribe(item => this.item = item);
   }
  }

  byUsed(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByCondition(false)
        .subscribe(item => this.item = item);
   }
  }

  by100(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByPrice(100)
        .subscribe(item => this.item = item);
   }
  }

  by200(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByPrice(200)
        .subscribe(item => this.item = item);
   }
  }

  by300(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByPrice(300)
        .subscribe(item => this.item = item);
   }
  }

  by400(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByPrice(400)
        .subscribe(item => this.item = item);
   }
  }
  
  by500(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByPrice(500)
        .subscribe(item => this.item = item);
   }
  }
  getItems(): void {
    this.itemService.getItems()
      .subscribe(items => this.items = items);
  }
}


