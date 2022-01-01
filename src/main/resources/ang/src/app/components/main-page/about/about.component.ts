import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../service-shared/user-service.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  name:string;
  constructor(private userServ:UserService) { }

  ngOnInit() {
    this.userServ.cast.subscribe(name=>this.name=name);
  }

}
