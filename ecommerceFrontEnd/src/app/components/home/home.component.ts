import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
 homeRate=3;

 onHomeRatingChanged(rate:number)
 {
  this.homeRate=rate;
 }
}
