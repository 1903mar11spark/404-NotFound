import { Component, OnInit, Input} from '@angular/core';
import { Observable, Subject } from 'rxjs';

import { Item } from '../item';
import { ItemC } from '../itemCreation';
import { ItemService }  from '../item.service';
import { FormGroup, FormControl } from '@angular/forms';
<<<<<<< HEAD
=======

>>>>>>> 613830c9b9ceba2ae04d23bd9ecea757f3e9ff6f

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {
  @Input() item: Item;
  items: Item[] = [];
  items$: Observable<Item>;
  sellForm: FormGroup;
  constructor( private itemService: ItemService) { 

this.sellForm = new FormGroup({
  itemName: new FormControl(),
  iCategory: new FormControl(),
  img: new FormControl(),
  price: new FormControl(),
  condition: new FormControl(),
  stock: new FormControl(),
  popularity: new FormControl(),
  userId:new FormControl()
})
}

addItem(): void{ 
 console.log(this.sellForm.value);
 var cate;
 if (this.sellForm.value.iCategory == "Videogame"){
       cate = 2;
     }else if (this.sellForm.value.iCategory == "Computer"){
       cate =1;
     }else if (this.sellForm.value.iCategory == "Accessories"){
       cate = 3;
     }
 var condi;
 if (this.sellForm.value.condition == "New"){
     condi = true;
    }else if (this.sellForm.value.condition == "Used"){
      condi = false;
  }

 const itemS: ItemC = {
  
   itemName: this.sellForm.value.itemName, 
   itemType: cate, 
   image: this.sellForm.value.img, 
   price: this.sellForm.value.price, 
   condition: condi, 
   stock: this.sellForm.value.stock, 
   popularity: 5.5, 
   userId: 1};
 this.itemService.addListing(itemS).subscribe(
  data  => { console.log("PUT Request is successful ", data);},
  error  => {console.log("Error", error);}
 );
}



  ngOnInit() {
  }

  // addItem():void{
  //   var name=((document.getElementById("itemName") as HTMLInputElement).value);
  //   name =name.trim();
  //   var cat=((document.getElementById("iCategory") as HTMLInputElement).value);
  //   var cate;
  //   if (cat == "Videogame"){
  //     cate = 2;
  //   }else if (cat == "Computer"){
  //     cate =1;
  //   }else if (cat == "Accesory"){
  //     cate = 3;
  //   }
  //   var condition=((document.getElementById("iCondition") as HTMLInputElement).value);
  //   var cond;
  //   if (condition == "New"){
  //     cond = true;
  //   }else if (condition == "Used"){
  //     cond = false;
  //   }
  //   var stock=((document.getElementById("stock") as HTMLInputElement).value);
  //   var stock2 = +stock;
  //   var price=((document.getElementById("price") as HTMLInputElement).value);
  //   var price2 = +price;
  //   var img=((document.getElementById("img") as HTMLInputElement).value);
  //   var popularity=0;
  //   const itemS: Item = {
  //     itemId:200,
  //     itemName: name,
  //     itemType: cate,
  //     image: img,
  //     price: price2,
  //     condition: cond,
  //     stock: stock2,
  //     popularity: popularity,
  //     userId:1
  //   };
<<<<<<< HEAD

  
=======
>>>>>>> 613830c9b9ceba2ae04d23bd9ecea757f3e9ff6f
}
