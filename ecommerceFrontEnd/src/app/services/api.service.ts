import { Injectable } from '@angular/core';
import { APIResponse } from '../models/api-response.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private _http:HttpClient) { }
  get(url:string){
   return this._http.get<APIResponse>(`http://localhost:7070/${url}`);
  }
  post(url:string,body:any){
    return this._http.post<APIResponse>(`http://localhost:7070/${url}`,body);
  }
  put(url:string,body:any){
    return this._http.put<APIResponse>(`http://localhost:7070/${url}`,body);
  }
  delete(url:string){
    return this._http.delete<APIResponse>(`http://localhost:7070/${url}`);
   }
}
