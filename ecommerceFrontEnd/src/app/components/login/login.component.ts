import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ElementRef, ViewChild } from '@angular/core';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  @ViewChild('passwordField') passwordField: ElementRef<HTMLInputElement>;

  constructor(private _formBuilder: FormBuilder) { }
  ngOnInit(): void {
    this.loginForm = this._formBuilder.group({
      // FirstName: ['', [Validators.required]],
      // LastName: ['', [Validators.required]],
      Email: ['', [Validators.required, Validators.email]],
      // NationalID: ['', [Validators.required, Validators.minLength(10)]],
      // Mobile: ['', [Validators.required, Validators.pattern(/01[0125][0-9]{8}/)]],
      // // Age: ['', [Validators.required, Validators.min(18)]],
      Password:['',[Validators.required , Validators.minLength(5)]]
      

    })
  }

  login(): void {
    //this.loginForm.value
    alert(JSON.stringify(this.loginForm.value));
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


