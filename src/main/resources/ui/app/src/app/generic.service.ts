import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpEvent, HttpHeaders, HttpRequest} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";

const baseUrl = 'http://localhost:8080/etl/transfer';

@Injectable({
  providedIn: 'root'
})
export class GenericService {


  private headers = new Headers({'Content-Type': 'application/json'});
  errorMsg: string = '';

  constructor(private _http: HttpClient) {
  }

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  submit(data: any): Observable<string> {
    return this._http.get(`${baseUrl}/${data.table}/${data.db}`, {responseType: 'text'});
  }

  uploadExcel(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `${baseUrl}/upload`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this._http.request(req).pipe(
      catchError(error => {

        if (error.error instanceof ErrorEvent) {
          this.errorMsg = `Error: ${error.error.message}`;
        } else {
          this.errorMsg = this.getServerErrorMessage(error);
        }

        return throwError(this.errorMsg);
      })
    );
  }

  private getServerErrorMessage(error: HttpErrorResponse): string {
    switch (error.status) {
      case 404: {
        return `Not Found: ${error.message}`;
      }
      default :{
        return `Unknow Response: ${error.message}`;
      }
    }
  }
}
