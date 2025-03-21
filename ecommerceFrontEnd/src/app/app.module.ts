import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TasksComponent } from './components/tasks/tasks.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
// import { ContactComponent } from './components/contact/contact.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { DetailsComponent } from './components/details/details.component';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './components/shared/header/header.component';
import { RatingComponent } from './components/shared/rating/rating.component';
import { StudentComponent } from './components/student/student.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { OrderComponent } from './components/order/order.component';
import { CartComponent } from './components/cart/cart.component';
import { ProductsComponent } from './components/products/products.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    HomeComponent,
    AboutComponent,
    // ContactComponent,
    NotFoundComponent,
    DetailsComponent,
    LoginComponent,
    HeaderComponent,
    RatingComponent,
    StudentComponent,
    SignUpComponent,
    OrderComponent,
    CartComponent,
    ProductsComponent,
    ProductDetailsComponent,
    CartDetailsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserAnimationsModule,

    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
