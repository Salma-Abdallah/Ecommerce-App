import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { APIResponse } from 'src/app/models/api-response.model';
import { CartRequestModel } from 'src/app/models/cartRequest.model';
import { ProductModel } from 'src/app/models/product.model';
import { UserModel } from 'src/app/models/user.model';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  products:ProductModel[]=[];
  cart:CartRequestModel;
  user:UserModel;

  constructor(private _httpClient: HttpClient,
      private _productService:ProductService,
      private _cartService:CartService) {
    }

  ngOnInit(): void {
    this._productService.get()
    .subscribe((response: APIResponse)=>{
      this.products = response.Data;
    },
    (error: any )=>{ alert("No Products Found")}
    )
  }

  viewDetails(product: ProductModel) {
    alert(`Viewing details for: ${product.Name}`);
  }

  addToCart(product: ProductModel) {
    const userData = sessionStorage.getItem("user");
    
    console.log("Raw User session data:", userData);
    
    if (userData) {
      try {
        this.user = JSON.parse(userData);
        console.log("Parsed User Data:", this.user);
  
        if (this.user && this.user.id) { // Ensure user has an ID
          this.cart = {
            UserId: this.user.id,  // Set user ID properly
            ProductId: product.Id, // Assuming product has an ID
            Quantity: 1
          };
          // console.log("UserId ---> "+this.cart.UserId);
          // console.log("ProductId ---> "+this.cart.ProductId);
          // console.log("Product.Id ---> "+ product.Id);
          // console.log("Quantity ---> "+this.cart.Quantity);
          // console.log("Cart data ---> "+this.cart);
  
          this._cartService.addToCart(this.cart)
            .subscribe(
              (response: any) => {
                if (response && response.Success) {
                  alert(`${product.Name} added to cart!`);
                } else {
                  alert(response.Message || "Something went wrong!");
                }
              },
              (error: any) => {
                console.error("Error:", error);
                alert("Error adding to cart. Please try again.");
              }
            );
        } else {
          alert("User ID is not found in session. Please log in.");
        }
      } catch {
        alert("User is not logged in. Please log in first.");
      }
    }
  }
  
}
