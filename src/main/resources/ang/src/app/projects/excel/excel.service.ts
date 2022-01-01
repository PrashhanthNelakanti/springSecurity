import {Injectable} from '@angular/core';
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ExcelService {

  basePath: string = 'http://localhost:5000/';
  private headers=new Headers({'Content-Type':'multipart/form-data'});
  private options=new RequestOptions({headers:this.headers});
  constructor(private _http:Http) { }
  status:boolean= false;

  errorHandler(error:Response){
    return Observable.throw(error||'SERVER ERROR');
  }

  upLoadExcel(event):Observable<any>  {
    let fileList: FileList = event.target.files;
    if(fileList.length > 0) {
      let file: File = fileList[0];
      let formData:FormData = new FormData();
      formData.append('file', file, file.name);
      let headers = new Headers();
      let options = new RequestOptions({ headers: headers });
     return  this._http.post(`${this.basePath+'upload'}`, formData, options)
        .map(res => res.json())
        .catch(error => Observable.throw(error))
    }
  }

  transferData(data):Observable<any>  {
    return  this._http.get(`${this.basePath+'etl/transfer/'+data.table+'/'+data.db}`)
      .map(res => res.json())
      .catch(error => Observable.throw(error))
  }

}
