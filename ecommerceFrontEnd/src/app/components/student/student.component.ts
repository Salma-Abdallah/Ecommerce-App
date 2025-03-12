import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { APIResponse } from 'src/app/models/api-response.model';
import { StudentViewModel } from 'src/app/models/viewModel';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent {
  students: StudentViewModel[] = [];
  constructor(private _httpClient: HttpClient, private _studentService:StudentService) {

  }
  ngOnInit(): void {
    // this._httpClient.get<APIResponse>("https://api.mohamed-sadek.com/Student/Get")
    //   .subscribe((response: APIResponse) => {
    //     this.students = response.Data;
    //   }
    //     , (error: any) => { alert("welcome") });
    this._studentService.get()
      .subscribe((response: APIResponse) => {
        this.students = response.Data;
      }
        , (error: any) => { alert("welcome") });

  }

  delete(index: number) {
    const student = this.students[index];
    this._studentService.delete(student.ID)
      .subscribe(
        {
          next: response => {
            this.students.splice(index, 1);
            alert(response.Message);
          }, error: error => { }
        }
      );
  }

}
