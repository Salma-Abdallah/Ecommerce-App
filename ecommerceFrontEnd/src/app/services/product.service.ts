
import { Injectable } from '@angular/core';
import { APIResponse } from '../models/api-response.model';

import { ApiService } from './api.service';
import { HttpClient } from '@angular/common/http';
import { CartModel } from '../models/cart.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService{
    constructor(private _http:HttpClient,private _apiService: ApiService) { }

    get(){
        return this._apiService.get("products");
    }
    addToCart(cart:CartModel){
        return this._apiService.post("carts",cart);
    }
    

}