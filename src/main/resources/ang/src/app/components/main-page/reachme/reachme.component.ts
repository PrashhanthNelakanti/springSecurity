import {Component, OnInit} from '@angular/core';
import {ReachmeService} from './reachme.service';
import {Contact} from './contact';
import {UserService} from '../../../service-shared/user-service.service';

@Component({
  selector: 'app-reachme',
  providers:  [ ReachmeService ],
  templateUrl: './reachme.component.html',
  styleUrls: ['./reachme.component.css']
})
export class ReachmeComponent implements OnInit {


  name:string;


  constructor(private service:ReachmeService,private userServ:UserService) { }
  mainmsg:string="Failed To Submit";
  msg:string;
  statusIcon:string="";
  contact:Contact = new Contact();
  contacts:any;
  cols:any;
  check=1;
  isLoaded:boolean;
  ngOnInit() {
    this.userServ.cast.subscribe(name=>this.name=name);
    this.getAllContacts();

  }

  addContact(){
    this.msg="";
    this.statusIcon="";
    this.check=1;
    this.contact.status='InProgress';
    if(this.contact.contactName=='' || this.contact.contactName==null){
      this.check--;
      this.msg="Recruiter's name cannot be empty.";
    }
    if(this.contact.descrption=='' || this.contact.descrption==null){
      this.check--;
      this.msg=this.msg+" Job description cannot be empty.";
    }
    if(this.contact.org=='' || this.contact.org==null){
      this.check--;
      this.msg= this.msg+" Orgnisation cannot be empty.";
    }
    if(this.check>0){
      this.service.addContact(this.contact).subscribe((contact)=>{
        console.log(contact);
        this.userServ.editName(this.contact.contactName);
        console.log("contact saved");
        this.statusIcon="ok";
        this.mainmsg="Successful";
        this.msg="The all fields are submitted. Thanks for reaching";
        this.getAllContacts();
      },(error)=>{
        console.log(error);
      });
    }
    else{
      this.statusIcon="cross"
    }

  }

  getAllContacts(){
    this.service.getAllContacts().subscribe(res =>{
      this.contacts = res;
      if(res != null || typeof res !== 'undefined')
        this.isLoaded = true
      this.cols=Object.keys(this.contacts[0])
      console.log(this.cols)
    })
  }

}
