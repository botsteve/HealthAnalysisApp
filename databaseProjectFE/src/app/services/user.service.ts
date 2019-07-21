import { User } from './../model/user';
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl: string = Constants.API_ENDPOINT + "users";
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


  getUserByEmail(email: String): Observable<User> {
    return this.httpClient.get<User>(this.baseUrl + '/emails?email=' + email);
  }

  logInUser(user: User): Observable<User> {
    return this.httpClient.post<User>(this.baseUrl + '/loggedIn', user);
  }

  updateUserLoggedIn(email: String): Observable<User> {
    return this.httpClient.put<User>(this.baseUrl + '/user', email);
  }

  updateUser(firstName: string, lastName: string): Observable<User> {
    let params = new HttpParams().set("firstName",firstName).set("lastName",lastName);
    return this.httpClient.put<User>(this.baseUrl + '/userChange', null, {params});
  }

  updateUserLoggingOut(): Observable<User> {
    return this.httpClient.put<User>(this.baseUrl + '/userLoggingOut', null);
  }

  registerUser(newUser: User): Observable<User> {
    return this.httpClient.post<User>(this.baseUrl + '/register', newUser);
  }
}
