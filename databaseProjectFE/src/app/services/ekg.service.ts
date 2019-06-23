import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EKG } from '../model/ekg';

@Injectable({
  providedIn: 'root'
})
export class EkgService {
  private baseUrl: string = 'http://localhost:8080/ekg';
  constructor(private httpClient: HttpClient) { }

  getEkgForUser(): Observable<EKG[]> {
    return this.httpClient.get<EKG[]>(this.baseUrl);
  }

  insertNewEKG(voltageValue: number): Observable<EKG> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    return this.httpClient.post<EKG>(this.baseUrl, voltageValue, { headers: headers });
  }
}
