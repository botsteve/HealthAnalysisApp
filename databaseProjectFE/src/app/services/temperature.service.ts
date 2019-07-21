import { Temperature } from './../model/temperature';
import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class TemperatureService {
  private baseUrl: string = Constants.API_ENDPOINT + "temperature";
  loggedUser: User = new User();


  constructor(private httpClient: HttpClient) { }

  getTemperatureForUser(): Observable<Temperature[]> {
    return this.httpClient.get<Temperature[]>(this.baseUrl);
  }

  insertNewTemp(tempValue: number): Observable<Temperature> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    return this.httpClient.post<Temperature>(this.baseUrl, tempValue, { headers: headers });
  }
}
