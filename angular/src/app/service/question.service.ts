import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import {Question} from './../model/question';
import {Page} from './../model/page';

import {BaseService} from './base.service';

@Injectable()
export class QuestionService extends BaseService{

  questionsListUrl = this.baseUrl + '/questions/list';
  newQuestionUrl = this.baseUrl + '/questions';
  deleteQuestionUrl = this.baseUrl + '/questions';

  constructor(private http: Http) { 
    super();
  }

  getQuestions(page, size) : Observable<Page<Question>> {
    return this.http.post(this.questionsListUrl, {
      "page":page,
      "size":size
    },
    this.headers)
    .map((res:Response) => res.json().page)
    .catch((error:any) => Observable.throw(error.json().error || 'Server error'));

  }

  saveQuestion(question): Observable<any> {
    return this.http.post(this.newQuestionUrl, question, this.headers)
    .catch((error:any) => {
      console.log(error);
      return Observable.throw(error.json().error || 'Server error');
    });
  }

  deleteQuestion(question): Observable<any> {
    console.log("deleting question: " + question);
    return this.http.delete(this.deleteQuestionUrl + "/" + question, this.headers)
    .catch((error:any) => {
      console.log(error);
      return Observable.throw(error.json().error || 'Server error');
    });
  }

}
