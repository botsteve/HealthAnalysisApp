import { User } from './../model/user';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl: string = 'http://localhost:8080/users';
  loggedUser: User = new User();

  constructor(private httpClient: HttpClient) {

  }

  getUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.baseUrl);
  }

  getUser(email: String): Observable<User> {
    return this.httpClient.get<User>(this.baseUrl + '/user?=email=' + email);
  }

  getLoggedUser(): Observable<User> {
    return this.httpClient.get<User>(this.baseUrl + '/loggedUser');
  }

  deleteUser(email: String): Observable<void> {
    return this.httpClient.delete<void>(this.baseUrl + '/delete?email=' + email);
  }

  createUser(user: User): Observable<User> {
    return this.httpClient.post<User>(this.baseUrl, user);
  }

  updateUser(user: User): Observable<User> {
    return this.httpClient.put<User>(this.baseUrl, user);
  }

  getUserByEmail(email: String): Observable<User> {
    return this.httpClient.get<User>(this.baseUrl + '/emails?email=' + email);
  }

  logInUser(user: User): Observable<User> {
    return this.httpClient.post<User>(this.baseUrl + '/loggedIn', user);
  }

  updateUserLoggedIn(email: String): Observable<User> {
    return this.httpClient.put<User>(this.baseUrl + '/user', email);
  }

  updateUserLoggingOut(): Observable<User> {
    return this.httpClient.put<User>(this.baseUrl + '/userLoggingOut', null);
  }

  registerUser(newUser: User): Observable<User> {
    return this.httpClient.post<User>(this.baseUrl + '/register', newUser);
  }
}
