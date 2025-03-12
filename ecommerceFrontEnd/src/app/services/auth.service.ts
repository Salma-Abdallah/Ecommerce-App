import { Injectable } from '@angular/core';
import { APIResponse } from '../models/api-response.model';
import { HttpClient } from '@angular/common/http';

import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    constructor(private _apiService:ApiService) { }
  get(){
   return this._apiService.get("users");
  }
}