import { Component, OnInit, Input } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { LocalStorage } from '@ngx-pwa/local-storage';
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

  constructor(private loginService: LoginService, protected localStorage: LocalStorage) { }

  ngOnInit() {
  }

  getloginId():void {
    var user=((document.getElementById("username") as HTMLInputElement).value);
    var pass=((document.getElementById("password") as HTMLInputElement).value);
        this.loginService.gettingUserId(user,pass)
        .subscribe(login => this.login = login);
         
        //Store local storage vairbale with the key 'id'
        localStorage.setItem('id', JSON.stringify({id:this.login}));

        this.locale();
       
      }

       locale ():void {
         //Get locale storage variable. Key is id
         console.log(JSON.parse(localStorage.getItem('id')));
        }
      
}