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
        this.itemService.getItemByType(2)
        .subscribe(items => this.items = items);
   }
  }

  byComputer(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByType(1)
        .subscribe(items=> this.items = items);
   }
  }

  byAccesories(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByType(3)
        .subscribe(items => this.items = items);
   }
  }

  byNew(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByCondition(true)
        .subscribe(items => this.items = items);
   }
  }

  byUsed(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByCondition(false)
        .subscribe(items => this.items = items);
   }
  }

  by100(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByPrice(0,100)
        .subscribe(items => this.items = items);
   }
  }

  by200(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByPrice(101, 200)
        .subscribe(items => this.items = items);
   }
  }

  by300(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByPrice(201,300)
        .subscribe(items => this.items = items);
   }
  }

  by400(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByPrice(301,400)
        .subscribe(items => this.items = items);
   }
  }
  
  by500(event) {
    if ( event.target.checked ) {
        this.itemService.getItemByPrice(401,500)
        .subscribe(items => this.items = items);
   }
  }
  getItems(): void {
    this.itemService.getItems()
      .subscribe(items => this.items = items);
  }
}


