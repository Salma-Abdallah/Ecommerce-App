import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { APIResponse } from 'src/app/models/api-response.model';
import { CartModel } from 'src/app/models/cart.model';
import { UserModel } from 'src/app/models/user.model';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {
  cart: CartModel[] = [];

  totalPrice: number = 0;
  isUpdated: boolean = false;
  cashOnDelivery: boolean = false;
  user: UserModel;

  constructor(private _http: HttpClient,
    private _cartService: CartService
  ) { }

  ngOnInit(): void {
    const userData = sessionStorage.getItem("user");

    if (userData) {
      try {
        this.user = JSON.parse(userData);
        if (this.user && this.user.id) {
          const id = this.user.id;
         

          this._cartService.get(this.user.id)
            .subscribe((response: APIResponse) => {
              this.cart = response.Data;
              console.log("Response message"+response.Message);
              console.log("user "+this.user.name);
              console.log("product 1 in cart "+this.cart[1].user.name);
              console.log("Total : "+this.calculateTotal());
               this.calculateTotal();
            },
              (error: any) => { alert("No cart Found") }
            )
          }

        } catch {

        }
      }
     
  }


    calculateTotal() {
      this.totalPrice = this.cart.reduce((sum, item) => sum + item.product.Price * item.quantity, 0);
    }

    updateQuantity() {
      this.isUpdated = true; // Enable update button when quantity changes
    }

    applyUpdate() {
      this.calculateTotal();
      this.isUpdated = false; // Disable update button after updating
    }

    placeOrder() {
      if (!this.cashOnDelivery) {
        alert("Please select 'Cash on Delivery' to proceed.");
        return;
      }
      alert("Order placed successfully!");
      this.cart = []; // Clear cart
      this.totalPrice = 0;
    }
  }



  
 //   this._http.get<APIResponse>(`http://localhost:7070/carts/${id}`)
          //     .subscribe((response: APIResponse) => {
          //       if (response && response.Success) {
          //         this.cart = response.Data;

          //         console.log("Products ---->"+this.cart[1].product.Id)
          //         console.log("Response Date ---> "+response.Message);
          //         console.log("Cart ---> "+this.cart.toString);
          //       } else {
          //         alert(response.Message || "Something went wrong!");
          //       }
          //     },
          //     (error: any) => {
          //       console.error("Error:", error);
          //       alert("Error getting to cart. Please try again.");
          //     }
          //     );
          // }