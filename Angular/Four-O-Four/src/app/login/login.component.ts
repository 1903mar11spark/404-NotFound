import { Component, OnInit, Input } from '@angular/core';
import { Observable, Subject } from 'rxjs';

import { Login } from '../loginI';
import { LoginService} from '../login.service'
 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input() login: Login;
  login$: Observable<Login>;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  getloginId():void {
    var user=((document.getElementById("username") as HTMLInputElement).value);
    var pass=((document.getElementById("password") as HTMLInputElement).value);
        this.loginService.gettingUserId(user,pass)
        .subscribe(login => this.login = login);
        console.log(this.login);
  }
}