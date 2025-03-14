
import { Injectable } from '@angular/core';
import { APIResponse } from '../models/api-response.model';

import { ApiService } from './api.service';
import { HttpClient } from '@angular/common/http';
import { CartRequestModel } from '../models/cartRequest.model';

@Injectable({
  providedIn: 'root'
})
export class CartService{
    constructor(private _http:HttpClient,private _apiService: ApiService) { }

    addToCart(cart:CartRequestModel){
        return this._apiService.post("carts",cart);
    }
    get(id:number){
      return this._apiService.get(`carts/${id}`)
    }

}