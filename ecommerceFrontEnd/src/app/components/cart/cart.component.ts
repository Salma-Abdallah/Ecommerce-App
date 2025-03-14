import { Component, OnInit } from '@angular/core';

interface CartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
}
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cart: CartItem[] = [
    { id: 1, name: 'Product 1', price: 50, quantity: 1 },
    { id: 2, name: 'Product 2', price: 30, quantity: 2 },
  ];

  totalPrice: number = 0;
  isUpdated: boolean = false;
  cashOnDelivery: boolean = false;

  ngOnInit() {
    this.calculateTotal();
  }
  calculateTotal() {
    this.totalPrice = this.cart.reduce((sum, item) => sum + item.price * item.quantity, 0);
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
