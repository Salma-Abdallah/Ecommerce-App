import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { APIResponse } from 'src/app/models/api-response.model';
import { Task } from 'src/app/models/task.model';
import { StudentViewModel } from 'src/app/models/viewModel';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  student: StudentViewModel;

  constructor(private _activatedRoute:ActivatedRoute,private _http:HttpClient){
    //alert("constructor");
  }
  ngOnInit(): void {
    this._activatedRoute.paramMap
    .subscribe(parms=>{
      let id=parms.get('id');
    this.getTaskByID(id);

    });
  }
  getTaskByID(id:string|null)
  {
    this._http.get<APIResponse>(`https://api.mohamed-sadek.com/Student/GetByID?id=${id}`)
    .subscribe(
      {
        next:reponse=>{
          this.student=reponse.Data;
        }
      }
    );
  }
  
  
}
