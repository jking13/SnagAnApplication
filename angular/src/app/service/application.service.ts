import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import {Application} from './../model/application';
import {Page} from './../model/page';

import {BaseService} from './base.service';

@Injectable()
export class ApplicationService extends BaseService{

  applicationsListUrl = this.baseUrl + '/applications/list';
  newApplicationUrl = this.baseUrl + '/applications';

  constructor(private http: Http) { 
    super();
  }

  getApplications(page, size) : Observable<Page<Application>> {
    return this.http.post(this.applicationsListUrl, {
      "page":page,
      "size":size
    },
    this.headers)
    .map((res:Response) => res.json().page)
    .catch((error:any) => Observable.throw(error.json().error || 'Server error'));

  }

  saveApplication(application): Observable<any> {
    console.log("service saving: ");
    console.log(application);
    return this.http.post(this.newApplicationUrl, application, this.headers)
    .catch((error:any) => {
      console.log(error);
      return Observable.throw(error.json().error || 'Server error');
    });
  }

}
