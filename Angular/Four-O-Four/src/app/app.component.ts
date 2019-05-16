import { Component, OnInit, Input} from '@angular/core';
import { LocalStorage } from '@ngx-pwa/local-storage';
import { User } from './user';
import {UserService} from './user.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Four-O-Four';
  user: User[];

  constructor(protected localStorage : LocalStorage,
    private userService: UserService) { 
    }

    ngOnInit() {
      let id = JSON.parse(localStorage.getItem('id'));
      let uId = id.id;
      console.log(uId);
      this.getUser(uId);
    }

    getUser(id: number):any{
      this.userService.getUser(id)
      .subscribe(user => this.user = user);
    }
}
