import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LivingRoom } from '../models/living-room';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LivingroomService {
  serverurl="http://localhost:9090"
  constructor(private http:HttpClient) { }


  getAll():Observable<LivingRoom[]>
  {
    return this.http.get<LivingRoom[]>(this.serverurl+"/livingroom")
  }

  getbyId(id:any):Observable<LivingRoom>
  {
    return this.http.get<LivingRoom>(this.serverurl+"/livingroom/"+id)
  }
  

  insert(formData:FormData):Observable<LivingRoom>
  {
    return this.http.post<LivingRoom>(this.serverurl+"/",formData)
  }

  update(formData:FormData,id:any):Observable<LivingRoom>{
    return this.http.put<LivingRoom>(this.serverurl+"/update/"+id,formData)
  }

  delete(id:any):Observable<Object>{
    return this.http.delete(this.serverurl+"/livingroom/"+id)
  }
}
