import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {User} from '../../user';
import {UserService} from '../../service-shared/user-service.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
public user: User;
  constructor(private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.user= this._userService.getter();
  }
  editForm(){
    this._userService.updateUser(this.user).subscribe((user)=>{
      console.log(user);
      console.log("editForm method");
      this._router.navigate(['/list']);
    },(error)=>{
      console.log(error);
    });
  }
}




