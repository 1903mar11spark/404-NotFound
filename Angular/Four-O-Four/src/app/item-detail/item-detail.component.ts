import { Component, OnInit, Input} from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Item } from '../item';
import { ItemService }  from '../item.service';
import { CartItem } from '../cartItem';
import { FormGroup, FormControl } from '@angular/forms';
import { LocalStorage } from '@ngx-pwa/local-storage';

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent implements OnInit {
  @Input() item: Item;
  cartForm: FormGroup;
  
  constructor(protected localStorage : LocalStorage, private route: ActivatedRoute,
    private itemService: ItemService,
    private location: Location){ 
    }

   
  ngOnInit(): void{
    const initialId = this.getItem();
    const initialPrice = this.getPrice();
   
    this.cartForm = new FormGroup({
      iId: new FormControl(),
      priceI: new FormControl(),
      quantity: new FormControl()
    })

    this.cartForm.get('iId').setValue(initialId)
    this.cartForm.get('priceI').setValue(initialPrice)
  }

  getItem():any{
    const id= +this.route.snapshot.paramMap.get('id');
    this.itemService.getItem(id)
    .subscribe(item => this.item = item);
    return id;
  }

  getPrice(): any{
    const pric= +this.route.snapshot.paramMap.get('price');
    return pric;
  }

  onToggle(item){
    console.log('toggle');
    item.completed = !item.completed;
    this.itemService.toggleCompleted(item).subscribe(item => console.log(item));
  }

  goBack(): void {
    this.location.back();
  }

  addTotheCart(): void{
    const id = JSON.parse(localStorage.getItem('id'));
    const uId = id.id;
    var price = this.cartForm.value.priceI;
    console.log(this.cartForm);
    console.log(this.cartForm.controls.priceI);
    console.log(this.cartForm.controls.iId);
    var p = +price;
    var total = (this.cartForm.value.quantity) * p;
    const cart: CartItem ={
      itemId:this.cartForm.value.iId,
      price: this.cartForm.value.priceI,
      quantity: this.cartForm.value.quantity,
      userId:uId,
      totalPrice: total};
      console.log(cart);
      this.itemService.addCart(cart).subscribe(
      data  => { console.log("PUT Request is successful ", data);},
      error  => {console.log("Error", error);}
     );
  }

}
