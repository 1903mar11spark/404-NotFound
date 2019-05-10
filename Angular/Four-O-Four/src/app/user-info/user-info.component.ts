import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  constructor() { 
    let btn = document.getElementById("userB");
    btn.addEventListener("click", (e:Event) => this.ableToModify());
  }

  ableToModify(){
    let usName = document.getElementsByClassName("user");
    
  }
  ngOnInit() {
  }

}
