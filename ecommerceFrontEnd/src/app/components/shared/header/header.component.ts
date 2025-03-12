import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { APIResponse } from 'src/app/models/api-response.model';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent  implements OnInit {
  tasksCount=0;
  constructor(private _taskService:TaskService){}
  ngOnInit(): void {
    this._taskService.get()
    .subscribe({
      next:response=>{
        this.tasksCount=response.Data.length;
      },
      error:error=>{}
    }
    );
  }

}
