import { Injectable } from '@angular/core';
import { APIResponse } from '../models/api-response.model';

import { ApiService } from './api.service';
// import { LoginRequest } from '../models/LoginRequest.model';

import { HttpClient } from '@angular/common/http';
import { UserModel } from '../models/user.model';
import { LoginRequest } from '../models/LoginRequest.model';
import { NewUserModel } from '../models/newUser.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private _http:HttpClient,private _apiService: ApiService) { }

  post<UserModel>(login: LoginRequest) {
    return this._apiService.post("users/login", login);
  }
  // post(login: LoginRequest){
  //   return this._http.post<UserModel>(`http://localhost:7070/users/login`,login);
  // }

  adduser(user:NewUserModel){
    return this._apiService.post("users", user);
  }

}
