import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TasksComponent } from './components/tasks/tasks.component';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { DetailsComponent } from './components/details/details.component';
import { LoginComponent } from './components/login/login.component';
import { StudentComponent } from './components/student/student.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'index',component:HomeComponent},
  {path:'home',component:HomeComponent},
  {path:'students/details/:id',component:DetailsComponent},
  {path:'tasks',component:TasksComponent},
  {path:'about',component:AboutComponent},
  {path:'signup',component:SignUpComponent},
  {path:'login',component:LoginComponent},
  {path:'students',component:StudentComponent},
  {path:'**',component:NotFoundComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
