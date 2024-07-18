import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminLogin } from '../models/admin-login';

@Injectable({
  providedIn: 'root'
})
export class AdminloginService {

  serverurl = "http://localhost:9090"

  constructor(private http:HttpClient) { }


  getAdmin(email:any,password:any):Observable<AdminLogin>
  {
    return this.http.get<AdminLogin>(this.serverurl+"/adminLogin/"+email+"/"+password)
  }


}
