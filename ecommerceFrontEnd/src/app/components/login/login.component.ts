import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ElementRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from 'src/app/services/auth.service';
import { UserModel } from 'src/app/models/user.model';
import { APIResponse } from 'src/app/models/api-response.model';
import { LoginRequest } from 'src/app/models/LoginRequest.model';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loginRequest:LoginRequest;
  user:UserModel;

  @ViewChild('passwordField') passwordField: ElementRef<HTMLInputElement>;

  constructor(private _formBuilder: FormBuilder , private _httpClient: HttpClient , private _authService:AuthService) { }
  
  ngOnInit(): void {
    this.loginForm = this._formBuilder.group({
      Email: ['', [Validators.required, Validators.email]],
      Password:['',[Validators.required , Validators.minLength(3)]]
      
    })
  }

  login(): void {
    const loginRequest = this.loginForm.value;

    this._authService.post(loginRequest)
    .subscribe(
      {
        next:response=>{
          if(response.Success)
          {
            this.user = response.Data;
            sessionStorage.setItem('user', JSON.stringify(this.user)); 
            alert(JSON.stringify(this.user))
          }
          else
          {
            console.log(response.Message);
            alert(response.Message);
          }},
        error:error=>{
          console.error("API Error:", error); 
          alert("Error");}
      }
      );
  }
  
  togglePasswordVisibility() {
    const field = this.passwordField.nativeElement;

    if (field.type === 'password') {
        field.type = 'text';
    } else {
        field.type = 'password';
    }
}

}


