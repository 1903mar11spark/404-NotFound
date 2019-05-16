import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import { User } from '../user';
import { Login } from '../loginI';
import { SignupService } from '../signup.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private location: Location, protected signupService : SignupService) { }

  ngOnInit() {
  }

  signup() : void{
    
    let login : Login ={

    USERNAME : ((document.getElementById("user") as HTMLInputElement).value),
    PASSWORD : ((document.getElementById("pass") as HTMLInputElement).value),
    USER_ID : 100,
    USER_TYPE : 1
    }
    let user : User = {
     FIRSTNAME : ((document.getElementById("fname") as HTMLInputElement).value),
     LASTNAME : ((document.getElementById("lname") as HTMLInputElement).value),
     ADDRESS : ((document.getElementById("addy") as HTMLInputElement).value),
     CITY : ((document.getElementById("city") as HTMLInputElement).value),
     ZIP : Number(((document.getElementById("zip") as HTMLInputElement).value)),
     COUNTRY : ((document.getElementById("country") as HTMLInputElement).value),
     USER_ID : login.USER_ID,
     SHANE_BUCKS_ID : 1
     
    }
    this.signupService.crudUser(user).subscribe(user => user = user);
    this.signupService.crudLogin(login).subscribe(login => login = login);
  }

  goBack(): void {
    this.location.back();
  }
}
