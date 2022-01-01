import {Injectable} from '@angular/core';
import {Headers, Http, RequestOptions, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Contact} from './contact';


@Injectable()
export class ReachmeService {

  //basePath: string = 'http://prashhanth-env.eba-yadxpypp.us-east-1.elasticbeanstalk.com/';
  basePath: string = 'http://localhost:5000/';
  private headers=new Headers({'Content-Type':'application/json'});
  private options=new RequestOptions({headers:this.headers});
  constructor(private _http:Http) { }
  contact:Contact;

  errorHandler(error:Response){
    return Observable.throw(error||'SERVER ERROR');
  }

  setter(contact:Contact){
  this.contact=contact;
  }

  getter(){
  return this.contact;
  }

  getAllContacts(){
    return this._http.get(this.basePath+'profile/all/contacts',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  addContact(contact:Contact){
    console.log(contact)
    return this._http.post(this.basePath+'profile/add/contact',contact, this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

}
