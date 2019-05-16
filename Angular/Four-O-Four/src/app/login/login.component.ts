import { Component, OnInit, Input, NgModule } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { LocalStorage } from '@ngx-pwa/local-storage';
import { Login } from '../loginI';
import { LoginService} from '../login.service'
import { Router } from '@angular/router';
import { HomeComponent } from '../home';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  @Input() login: Login;
  login$: Observable<Login>;

  constructor(private loginService: LoginService, 
    protected localStorage: LocalStorage, private router: Router) { }

  ngOnInit() {
  }

  getloginId():void {
    var user=((document.getElementById("userName") as HTMLInputElement).value);
    var pass=((document.getElementById("password") as HTMLInputElement).value);
    console.log(user + pass);
        this.loginService.gettingUserId(user,pass)
        .subscribe(login => this.login = login);
         
        //Store local storage vairbale with the key 'id'
        localStorage.setItem('id', JSON.stringify({id:this.login}));

        this.locale();
       
      }

       locale ():void {
         //Get locale storage variable. Key is id
         console.log(JSON.parse(localStorage.getItem('id')));
         var ide = JSON.parse(localStorage.getItem('id'));
         var num = ide.id;
         if (num > 0){
          this.router.navigate(['./home']);
         
         }else{
          alert("Invalid Username or password ");
         }
        }
      
}