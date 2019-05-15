import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { ItemService }  from '../item.service';

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {
 items: Item[];
  constructor( private itemService: ItemService) { }

  ngOnInit() {
  }

  addItem():void{
    var name=((document.getElementById("itemName") as HTMLInputElement).value);
    name =name.trim();
    var cat=((document.getElementById("iCategory") as HTMLInputElement).value);
    var cate;
    if (cat == "Videogame"){
      cate = 2;
    }else if (cat == "Computer"){
      cate =1;
    }else if (cat == "Accesory"){
      cate = 3;
    }
    var condition=((document.getElementById("iCondition") as HTMLInputElement).value);
    var cond;
    if (condition == "New"){
      cond = 1;
    }else if (condition == "Used"){
      cond = 0;
    }
    var stock=((document.getElementById("stock") as HTMLInputElement).value);
    var stock2 = +stock;
    var price=((document.getElementById("price") as HTMLInputElement).value);
    var price2 = +price;
    var img=((document.getElementById("img") as HTMLInputElement).value);
    var popularity=0;
    const item: Item = {
      itemId:200,
      itemName: name,
      itemType: cate,
      image: img,
      price: price2,
      condition: cond,
      stock: stock2,
      popularity: 0,
      userId:1
    };
    this.itemService.addListing(item)
    .subscribe(item=> {
      this.items.push(item);
    });
  }
}
