import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { APIResponse } from 'src/app/models/api-response.model';
import { ProductModel } from 'src/app/models/product.model';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent {
  product:ProductModel;
  constructor(private _activatedRoute:ActivatedRoute,private _http:HttpClient){
      //alert("constructor");
    }
    ngOnInit(): void {
      this._activatedRoute.paramMap
      .subscribe(parms=>{
        let id=parms.get('id');
      this.getProductByID(id);
  
      });
    }

    getProductByID(id:string|null)
      {
        this._http.get<APIResponse>(`http://localhost:7070/products/${id}`)
        .subscribe(
          {
            next:reponse=>{
              this.product=reponse.Data;
            }
          }
        );
      }

}
