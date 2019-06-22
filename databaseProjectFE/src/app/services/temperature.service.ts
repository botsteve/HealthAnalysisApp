import { Temperature } from './../model/temperature';
import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TemperatureService {
  private baseUrl: string = 'http://localhost:8080/temperature';
  loggedUser: User = new User();


  constructor(private httpClient: HttpClient) { }

  getTemperatureForUser(): Observable<Temperature[]> {
    return this.httpClient.get<Temperature[]>(this.baseUrl);
  }
}
