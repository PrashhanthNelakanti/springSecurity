import {Component, OnInit} from '@angular/core';
import {ExcelService} from "./excel.service";

@Component({
  selector: 'app-excel',
  templateUrl: './excel.component.html',
  styleUrls: ['./excel.component.css']
})
export class ExcelComponent implements OnInit {

  constructor(private service: ExcelService) {
  }

  status: string = '';
  msg: string = '';
  table: string = "";
  db: string = "";
  data: any = {};
  respObj: any = {};

  ngOnInit() {
  }


  handleFileInput($event) {
    this.service.upLoadExcel($event).subscribe(
      data => console.log('success'),
      error => this.validateStatus(error)
    );
  }

  validateStatus(data: any) {
    console.log(data)
    if (data.toString().includes("Unexpected token")) {
      this.status = 'success';
      this.data.msg = 'The Process was Executed SuccessFully!';
    } else {
      this.status = 'failed';
      this.data.msg = 'There was a problem while Processing data';
    }
  }

  onSubmit() {
    this.data.table = this.table
    this.data.db = this.db
    this.service.transferData(this.data).subscribe(
      data => console.log('success'),
      error => this.validateStatus(error)
    );
  }


}
