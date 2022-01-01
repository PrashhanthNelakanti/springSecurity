import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {User} from '../../user';
import {UserService} from '../../service-shared/user-service.service';

@Component({
  selector: 'app-get-user',
  templateUrl: './get-user.component.html',
  styleUrls: ['./get-user.component.css']
})
export class GetUserComponent implements OnInit {

  constructor(private _userService:UserService,private _router:Router) { }
  public user=new User();
  ngOnInit() {

  }
getUser(id:number){
   this._userService.getUser(id).subscribe((user)=>{
    this.user=user;
    console.log(id);
    console .log(user);
  },(error)=>{
    console.log(error);
  })
}
listUser(){
  this._router.navigate(['/']);
}
}
