import { GPS } from './../model/gps';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GpsService {
  private baseUrl: string = 'http://localhost:8080/gps';
  constructor(private httpClient: HttpClient) { }

  getGpsLocationForUser(): Observable<GPS[]> {
    return this.httpClient.get<GPS[]>(this.baseUrl);
  }

  insertNewGPSLocation(gps: GPS): Observable<GPS> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    return this.httpClient.post<GPS>(this.baseUrl, gps, { headers: headers });
  }
}
