import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MyCart } from '../models/my-cart';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyCartService {
  serverurl="http://localhost:9090"
  constructor(private http:HttpClient) { }


  insert(mc:MyCart):Observable<MyCart>{
    return this.http.post<MyCart>(this.serverurl+"/mycart",mc)
  }

  getByEmail(e:any):Observable<MyCart[]>{
    return this.http.get<MyCart[]>(this.serverurl+"/mycart/"+e)
  }
  getByid(id:any):Observable<MyCart>{
    return this.http.get<MyCart>(this.serverurl+"/mycartt/"+id)
  }

}
