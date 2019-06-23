import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EMG } from '../model/emg';

@Injectable({
  providedIn: 'root'
})
export class EmgService {
  private baseUrl: string = 'http://localhost:8080/emg';
  constructor(private httpClient: HttpClient) { }

  getEmgForUser(): Observable<EMG[]> {
    return this.httpClient.get<EMG[]>(this.baseUrl);
  }

  insertNewEMG(voltageValue: number): Observable<EMG> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    return this.httpClient.post<EMG>(this.baseUrl, voltageValue, { headers: headers });
  }
}
