import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Register } from '../models/register';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
serverurl="http://localhost:9090"
  constructor(private http: HttpClient) { }

  getAll():Observable<Register[]>{
    return this.http.get<Register[]>(this.serverurl+"/register")
  }

  insert(r:Register):Observable<Register>{
    return this.http.post<Register>(this.serverurl+"/register",r)
  }

  getLogin(e:any,p:any):Observable<Register>{
    return this.http.get<Register>(this.serverurl+"/login/"+e+"/"+p)
  }
}
