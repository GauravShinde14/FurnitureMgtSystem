import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Buynow } from '../models/buynow';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BuynowService {
  serverurl="http://localhost:9090"
  constructor(private http:HttpClient) { }


  insert(bn:Buynow):Observable<Buynow>{
    return this.http.post<Buynow>(this.serverurl+"/buynow",bn)
  }

  getALL():Observable<Buynow[]>{
    return this.http.get<Buynow[]>(this.serverurl+"/buynow")
  }

  
}
