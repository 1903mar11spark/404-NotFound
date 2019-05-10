import { Component, OnInit, Input} from '@angular/core';
import { Location } from '@angular/common';

import { Item } from '../item';
import { ItemService }  from '../item.service';

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent implements OnInit {
  @Input() item: Item;
  
  constructor(private itemService: ItemService,
    private location: Location) { }

  ngOnInit(){
  }

  setClasses(){
    let classes = {
      item: true,
      'is-compleated': this.item.completed
    }
    return classes;
  }

  onToggle(item){
    console.log('toggle');
    item.completed = !item.completed;
    this.itemService.toggleCompleted(item).subscribe(item => console.log(item));
  }

  goBack(): void {
    this.location.back();
  }

}
