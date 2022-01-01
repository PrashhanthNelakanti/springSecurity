import {Injectable} from '@angular/core';
import {Headers, Http, RequestOptions, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {BehaviorSubject} from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {User} from '../user';

@Injectable()
export class UserService {
private basePath:String='http://localhost:5000';
private headers=new Headers({'Content-Type':'application/json'});
private options=new RequestOptions({headers:this.headers});
private user:User;
private name= new BehaviorSubject <string>('NewTon');
cast=this.name.asObservable();

  constructor(private _http:Http) { }

  getUsers(){
    return this._http.get(this.basePath+'/all',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getUser(id:Number){
    return this._http.get(this.basePath+'/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  createUser(user:User){
    return this._http.post(this.basePath+'/',JSON.stringify(user), this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  deleteUser(id:Number){
    return this._http.delete(this.basePath+'/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  updateUser(user:User){

    return this._http.put(this.basePath+'/'+this.user.id,JSON.stringify(user) ,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
    return Observable.throw(error||'SERVER ERROR');
  }
  setter(user:User){
  this.user=user;
  }
  getter(){
  return this.user;
  }


  editName(newName){
    this.name.next(newName);
  }
}
