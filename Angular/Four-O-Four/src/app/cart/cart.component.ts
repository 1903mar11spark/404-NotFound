import { Component, OnInit, Input} from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';
import { LocalStorage } from '@ngx-pwa/local-storage';

import { CartItem} from'../cartItem';
import { CartService } from '../cart.service';
import { ItemService } from '../item.service';
import { User } from '../user';
import { UserService } from '../user.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
cartItems: CartItem[] = [];
cartForm: FormGroup;
user: User[];
cartItemForm: FormGroup;

  constructor(private cartService: CartService,
              private itemService: ItemService,
              private userService: UserService,
              protected localStorage : LocalStorage) { }

  ngOnInit() {
    const id = JSON.parse(localStorage.getItem('id'));
    const uId = id.id;
    this.getUser(uId);
    const initialQ = this.getCart();
    this.cartItemForm = new FormGroup({
      quantity: new FormControl()
    })
    this.cartForm = new FormGroup({

    })

  this.cartItemForm.get('quantity').setValue(initialQ);
  }

  getUser(userI: number):any{
    this.userService.getUser(userI)
    .subscribe(user => this.user = user);
    return userI;
  }

  getCart(): any{
    const id = JSON.parse(localStorage.getItem('id'));
    const uId = id.id;
    this.cartService.getCarts(uId)
    .subscribe(cartItems => this.cartItems = cartItems);
    return uId;
  }

}
