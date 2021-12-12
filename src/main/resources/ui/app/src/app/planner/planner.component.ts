import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-planner',
  templateUrl: './planner.component.html',
  styleUrls: ['./planner.component.css']
})
export class PlannerComponent implements OnInit {

  playerData$: any;
  fakeArray = new Array(60);
  users =[{
      "username": "Martin",
      "meeting": "TownHall",
      "loc": "Hyd",
      "meetingRoom": "L1-Wrp",
      "priority": "High",
      "startTime":"7",
      "endTime":"9",
    },
    {
      "username": "Novic",
      "meeting": "TownHall",
      "loc": "Hyd",
      "meetingRoom": "L1-Wrp",
      "priority": "High",
      "startTime":"7",
      "endTime":"9",
    }]
  constructor() {
    this.playerData$ = 10;
    type Val = 1 | 2 | 3;
  }


  ngOnInit(): void {
    console.log(this.users[0])
  }

  getIndex(event:any){
    let num=((event/4)+6);
    var n = (num + "").split(".").map(Number);
    if(n[1] == 25){
      n[1]=15;
    }
    if(n[1] == 5){
      n[1]=30;
    }
    if(n[1] == 75){
      n[1]=45;
    }
    console.log(n);
    console.log(event);
  }

  classMap = {
    1: 'chg',
    2: 'second-element',
    3: 'third-element',
  }

}
