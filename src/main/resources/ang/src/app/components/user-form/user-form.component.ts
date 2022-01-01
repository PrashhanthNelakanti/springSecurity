import {Component, OnInit} from '@angular/core';
import {User} from '../../user';
import {UserService} from '../../service-shared/user-service.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
    public user:User;

      constructor(private _userService:UserService,private _router:Router) { }

      ngOnInit() {
        let usernew=new User();
        this._userService.setter(usernew);
       this.user= this._userService.getter();

      }
      processForm(){
          this._userService.createUser(this.user).subscribe((user)=>{
            console.log(user);
            console.log("userForm");
            this._router.navigate(['/list']);
          },(error)=>{
            console.log(error);
          });
        }
    }
