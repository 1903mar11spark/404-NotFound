import { LocalStorage } from '@ngx-pwa/local-storage';
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';

import { Login } from './loginI';
import { MessageService } from './message.service';
import { User } from './user';

const httpOptions = {
  headers: new HttpHeaders({ 'content-Type': 'application/json' })
};

@Injectable({providedIn: 'root'})

export class LoginService {
  localStorage: LocalStorage;

  constructor(
    private http: HttpClient, 
    private messageService: MessageService) { }

    private urlId: string = 'http://localhost:8084/404NotFound2/login';

    gettingUserId(userName: string, password: string): Observable<Login> {
      const url = `${this.urlId}/${userName}/${password}`;
      console.log(url);
      
      return this.http.get<Login>(url).pipe(
        tap(_ => console.log(`fetched user id=${userName}/${password}`)),
        catchError(this.handleError<Login>(`gettingUserId user_id=${userName}/${password}`))
        
      );
      
    }  

    private handleError<T> (operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
        console.error(error);
        this.log(`${operation} failed: ${error.message}`);
        return of(result as T);
      };
    }
   
    private log(message: string) {
      this.messageService.add(`itemService: ${message}`);
    }
}
  