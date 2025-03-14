import { Injectable } from '@angular/core';
import { APIResponse } from '../models/api-response.model';
import { HttpClient } from '@angular/common/http';
import { Student } from '../models/student.model';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private _apiService:ApiService) { }
  get(){
   return this._apiService.get("Student/Get");
  }
  post(student:Student){
    return this._apiService.post("Student/POST", student);
  }
  update(student:Student){
    return this._apiService.put("Student/PUT",student);
  }
  delete(id:number){
    return this._apiService.delete(`Student/delete?id=${id}`);
   }
}


