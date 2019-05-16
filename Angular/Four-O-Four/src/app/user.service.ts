import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';

import { User } from './user';
import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'content-Type': 'application/json' })
};

@Injectable({providedIn: 'root'})
export class UserService {

  constructor(private http: HttpClient, 
    private messageService: MessageService) { }
      private getUserUrl: string = 'http://localhost:8084/404NotFound2/user';
    
      getUser(userId: number): Observable<User[]>{
        console.log(this.http.get<User[]>(`${this.getUserUrl}/${userId}`));
        return this.http.get<User[]>(`${this.getUserUrl}/${userId}`);
      }
}
