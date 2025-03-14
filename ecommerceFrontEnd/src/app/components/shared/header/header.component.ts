import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { APIResponse } from 'src/app/models/api-response.model';
import { UserModel } from 'src/app/models/user.model';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent  implements OnInit {
  tasksCount=0;
  user:UserModel;
  isLoggedIn: boolean = false;

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
    const userData = sessionStorage.getItem("user");
    if(userData) {
      this.isLoggedIn = true;
      this.user = JSON.parse(userData);
    }
  }
  logout(): void {
    sessionStorage.removeItem('user');
    alert(JSON.stringify(sessionStorage.getItem('user')))
    this.user.name="";
    this.user.email="";
    this.user.password="";
    this.user.id=0;
    this.isLoggedIn = false;
  }

}
