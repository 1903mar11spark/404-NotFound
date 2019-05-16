import { Injectable } from '@angular/core';
import {
  HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpHeaders, HttpClient
} from '@angular/common/http';


import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import { User } from './user';
import { Login } from './loginI';

const httpOptions = {
  headers: new HttpHeaders({ 'content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})


export class SignupService {
  constructor(
    private http: HttpClient) { }

    private userUrl: string = 'http://localhost:8080/404NotFound2/user';
    private loginURL: string = 'http://localhost:8080/404NotFound2/login';

  /** POST: add a new user and login to the database */
crudUser (user: User): Observable<User> {
  const url = `${this.userUrl}/${user}`;
  return this.http.post<User>(url, user, httpOptions);
}

crudLogin (login: Login): Observable<Login> {
  const url = `${this.loginURL}/${login}`;
  return this.http.post<Login>(url, login, httpOptions);
}


//this.posts = this.http.get<Post[]>(this.rooturl + '/posts')
}
