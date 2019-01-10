import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiClientService {

  constructor(private http: HttpClient) { }

  getNews(): Observable<any> {
    return this.http.get('https://newsapi.org/v2/top-headlines?country=us&category=entertainment&pageSize=5&apiKey=fd9ec8dbca4c475395e2bcdde1262369');
  }
}
