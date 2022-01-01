import {Component, OnInit} from '@angular/core';
import {User} from '../../user';
import {Router} from '@angular/router';
import {UserService} from '../../service-shared/user-service.service';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {
  public users:User[];
  constructor(private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this._userService.getUsers().subscribe((users)=>{
      this.users=users;
      console.log(users);
    },(error)=>{
      console.log(error);
    })
  }

  deleteUser(user){
    this._userService.deleteUser(user.id).subscribe((data)=>{
      this.users.splice(this.users.indexOf(user),1);
      console.log("function is called");
      this._router.navigate(['/list']);
    },(error)=>{
      console.log(error);
    })
  }
  update(user){
    this._userService.setter(user);
    this._router.navigate(['/edit']);
    console.log("updateUser listForm");
  }

}
