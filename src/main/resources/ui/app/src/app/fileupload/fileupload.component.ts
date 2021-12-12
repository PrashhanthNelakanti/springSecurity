import {Component, OnInit} from '@angular/core';
import {GenericService} from "../generic.service";

@Component({
  selector: 'app-fileupload',
  templateUrl: './fileupload.component.html',
  styleUrls: ['./fileupload.component.css']
})
export class FileuploadComponent implements OnInit {

  status: string = '';
  msg: string = '';
  table: string = "";
  db: string = "";
  data: any = {};
  respObj: any = {};
  selectedFiles?: FileList;
  currentFile?: File;
  progress = 0;
  message = '';


  constructor(private service: GenericService) {
  }

  onSubmit() {
    this.respObj=('Failed')
    this.data.table = this.table
    this.data.db = this.db
    this.service.submit(this.data).subscribe(res => {
      this.respObj = res;
      console.log(this.respObj)
      this.statusChk(this.respObj);

    });
    this.statusChk(this.respObj);
  }


  statusChk(res: any) {
    if (res.includes("INSERT SUCCESS")) {
      this.status = 'success'
      this.msg = 'Data insertion was Successfull!';
      return;
    }
    if (res.includes("Failed")) {
      this.status = 'failed'
      this.msg = 'There was an problem while Transfering';
    } else {
      this.status = 'failed'
      this.msg = 'There was an problem while Transfering';
    }
    this.respObj = [];
  }

  ngOnInit(): void {
  }

}
