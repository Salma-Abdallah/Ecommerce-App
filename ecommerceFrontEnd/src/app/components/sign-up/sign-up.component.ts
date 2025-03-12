import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Student } from 'src/app/models/student.model';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'signUp',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  signupForm:FormGroup;

  constructor(private _formBuilder: FormBuilder ,private _studentService:StudentService ) { }

  ngOnInit(): void {
    this.signupForm = this._formBuilder.group({
      FirstName: ['', [Validators.required]],
      LastName: ['', [Validators.required]],
      Email: ['', [Validators.required, Validators.email]],
      NationalID: ['', [Validators.required, Validators.minLength(10)]],
      Mobile: ['', [Validators.required, Validators.pattern(/01[0125][0-9]{8}/)]],
      Age: ['', [Validators.required, Validators.min(18)]]

    })
  }

  add(firstName:string,lastName:string , mobile:string , email:string ,nationalID:string , age:number ){
    let student = new Student();
    student.FirstName = firstName;
    student.LastName = lastName;
    student.Mobile = mobile;
    student.Email = email;
    student.NationalID = nationalID;
    student.Age = age;

    this._studentService.post(student)
    .subscribe(
      {
        next:response=>{
          if(response.Sucess)
          {
            alert(response.Message);
            // student.ID=response.Data;
            // this.tasks.push(task);
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
