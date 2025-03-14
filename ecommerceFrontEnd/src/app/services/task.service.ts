import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APIResponse } from '../models/api-response.model';
import { Task } from '../models/task.model';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private _apiService:ApiService) { }
  get(){
   return this._apiService.get("Task/Get");
  }
  post(task:Task){
    return this._apiService.post("Task/POST",task);
  }
  put(task:Task){
    return this._apiService.put("Task/PUT",task);
  }
  delete(id:number){
    return this._apiService.delete(`Task/delete?id=${id}`);
   }
}
