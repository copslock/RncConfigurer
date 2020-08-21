import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import {Rnc} from '../../model/model.rnc';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DownloadService {

  public API = 'http://localhost:4201/api/v1/rnc-maximo-table/';

  headers = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      JSESSIONID: this.cookieService.get('JSESSIONID')
    })
  };

  constructor(private http: HttpClient, private cookieService: CookieService) {
  }

  getFile(): Observable<any> {
    return this.http.get(this.API + 'downloadFile/RncMaximoTableSample.csv', {responseType: 'blob' as 'json', observe: 'response'});
  }

  getFiles(): Observable<any> {
    return this.http.get(this.API + 'fileNames');
  }

  getTable(filename: string): Observable<any> {
    return this.http.get(this.API + 'file/' + filename);
  }

  getMapTable(filename: string): Observable<any> {
    return this.http.get(this.API + filename);
  }

  saveRnc(value) {
    console.log(value);
    this.http.post(this.API + 'repo/save', value).subscribe(data => {
      console.log('submitted successfully');
    }, error => {
      console.log('something went wrong', error);
    });
  }

  checkRnc(id: number): Observable<any> {

    console.log('before send checking request ', id);

    return this.http.get(this.API + 'repo/check/' + id);

  }

  inputChanges(fileOfChanges: string): Promise<object> {
    return this.http.get(this.API + 'modifyFile/' + fileOfChanges).toPromise();
  }
}
