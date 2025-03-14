import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NewUserModel } from 'src/app/models/newUser.model';
import { Student } from 'src/app/models/student.model';
import { AuthService } from 'src/app/services/auth.service';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'signUp',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  signupForm:FormGroup;

  constructor(private _formBuilder: FormBuilder ,
    private _authService:AuthService,
    private router:Router) { }

  ngOnInit(): void {
    this.signupForm = this._formBuilder.group({
      Name: ['', [Validators.required]],
      Email: ['', [Validators.required, Validators.email]],
      Password: ['', [Validators.required, Validators.minLength(3)]],

    })
  }

  add(name:string,email:string ,password:string ){
    // let student = new Student();
    // student.FirstName = Name;
    // student.Email = email;
    // student.NationalID = nationalID;
    // student.Age = age;
    let newUser = new NewUserModel;
    newUser.name=name;
    newUser.email=email;
    newUser.password=password;
    newUser.isAdmin=0;

    this._authService.adduser(newUser)
    .subscribe(
      {
        next:response=>{
          if(response.Success)
          {
            alert(response.Message);
            newUser=response.Data;
            sessionStorage.setItem('user', JSON.stringify(newUser)); 
            this.router.navigate(['/products']);

          }
          else
          {
            alert(response.Message);
          }},
        error:error=>{alert("Error");}
      }
      );

  }

}
