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
  deleteApplicationUrl = this.baseUrl + '/applications';

  constructor(private http: Http) { 
    super();
  }

  getApplications(page, size, query) : Observable<Page<Application>> {
    return this.http.post(this.applicationsListUrl, {
      "page":page,
      "size":size,
      "query":query
    },
    this.headers)
    .map((res:Response) => res.json().page)
    .catch((error:any) => Observable.throw(error.json().error || 'Server error'));

  }

  saveApplication(application): Observable<any> {
    return this.http.post(this.newApplicationUrl, application, this.headers)
    .catch((error:any) => {
      return Observable.throw(error.json().error || 'Server error');
    });
  }

  deleteApplication(application): Observable<any> {
    return this.http.delete(this.deleteApplicationUrl + "/" + application, this.headers)
    .catch((error:any) => {
      return Observable.throw(error.json().error || 'Server error');
    });
  }

}
