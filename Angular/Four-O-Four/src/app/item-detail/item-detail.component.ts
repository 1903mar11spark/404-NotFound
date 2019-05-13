import { Component, OnInit, Input} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
  
  constructor(private route: ActivatedRoute,
    private itemService: ItemService,
    private location: Location) { }

  ngOnInit(): void{
    this.getItem();
  }

  getItem():void{
    const id= +this.route.snapshot.paramMap.get('id');
    this.itemService.getItem(id)
    .subscribe(item => this.item = item);
  }

  onToggle(item){
    console.log('toggle');
    item.completed = !item.completed;
    this.itemService.toggleCompleted(item).subscribe(item => console.log(item));
  }

  goBack(): void {
    this.location.back();
  }

  addToCart(): void{

  }

}
