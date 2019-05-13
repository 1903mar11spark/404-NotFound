import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';

import { User } from './user';
import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserInfoService {

  constructor(
    private http: HttpClient, 
    private messageService: MessageService) { }

    private userUrl: string = 'localhost:8084/404NotFound2/';

    getUser(id: number): Observable<User> {
      const url = `${this.userUrl}/${id}`;
      return this.http.get<User>(url).pipe(
        tap(_ => this.log(`fetched user id=${id}`)),
        catchError(this.handleError<User>(`getUser id=${id}`))
      );
    }

    
  toggleCompleted(user: User):Observable<any>{
    const url = `${this.userUrl}/${user.USER_ID}`;
    return this.http.put(url, user, httpOptions);
  }
  
    private handleError<T> (operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
        console.error(error);
        this.log(`${operation} failed: ${error.message}`);
        return of(result as T);
      };
    }
   
    /** Log a HeroService message with the MessageService */
    private log(message: string) {
      this.messageService.add(`user-InfoService: ${message}`);
    }
  }
