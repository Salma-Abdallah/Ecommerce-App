import { HttpClient } from '@angular/common/http';
import { Task } from './../../models/task.model';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { APIResponse } from 'src/app/models/api-response.model';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit ,OnDestroy {
  name="Mohamed Ali";
  tasks:Task[]=[];
constructor(private _http:HttpClient){
  //alert("constructor");
}
  ngOnDestroy(): void {
    
  }
  ngOnInit(): void {
    //alert("ngOnInit");
    this._http.get<APIResponse>("https://api.mohamed-sadek.com/Task/Get")
    .subscribe({
      next:response=>{
        this.tasks=response.Data;
      },
      error:error=>{}
    }
    );
    //alert("2");

    //Send Email
    //Send SMS
  }
  add(title:string):void{
    let task=new Task();
    task.Title=title;
    
    this._http.post<APIResponse>("https://api.mohamed-sadek.com/Task/POST",task)
    .subscribe(
      {
        next:response=>{
          if(response.Sucess)
          {
            alert(response.Message);
            task.ID=response.Data;
            this.tasks.push(task);
          }
          else
          {
            alert(response.Message);
          }},
        error:error=>{alert("Error");}
      }
      );
  }

  update(task:Task):void
  {
    task.IsDone=!task.IsDone;
    this._http.put<APIResponse>("https://api.mohamed-sadek.com/Task/PUT",task)
    .subscribe(
      {
        next:response=>{},
        error:error=>{}
      }
    );
  }

  delete(index:number)
  {
    let task=this.tasks[index];
    this._http.delete<APIResponse>(`https://api.mohamed-sadek.com/Task/Delete?id=${task.ID}`)
    .subscribe(
      {
        next:reposnse=>{
          this.tasks.splice(index,1);
          alert(reposnse.Message);
        },
        error:error=>{}
        
      }
    );
    
  }
  getPendingTasksCount():number
  {
    return this.tasks.filter(x=>!x.IsDone).length;
  }
}
