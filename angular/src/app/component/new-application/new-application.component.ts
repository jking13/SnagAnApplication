import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { Question } from '../../model/question';
import { QuestionService } from '../../service/question.service';
import { ApplicationService } from '../../service/application.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-application',
  templateUrl: './new-application.component.html',
  styleUrls: ['./new-application.component.css'],
  providers: [QuestionService, ApplicationService]
})
export class NewApplicationComponent implements OnInit {

  loading: boolean = true;

  questions: Array<Question>;

  public newApplicationForm = this.fb.group({
    name: ["", Validators.required]
  });

  constructor(public fb: FormBuilder,
  				private questionService: QuestionService,
  				private applicationService: ApplicationService,
  				private router: Router) { 
  	var _this = this;
    this.questionService.getQuestions(0, 100, '').subscribe(data => {
      _this.questions = data.content;
      _this.loadQuestionsToForm();
      _this.loading = false;
    });
  }

  loadQuestionsToForm(){
  	this.questions.forEach(question =>{
  	  this.newApplicationForm.addControl(question.id, new FormControl("", Validators.required));
  	});
  }

  doSave(event) {
    var _this = this;
    var formValue = this.newApplicationForm.value;
    var applicationQuestions = [];
    this.questions.forEach(question => {
    	applicationQuestions.push({
    		id: question.id,
    		answer: formValue[question.id]
    	});
    });
    var application = {
    	name: formValue["name"],
    	questions: applicationQuestions
    };
    this.applicationService.saveApplication(application)
    .subscribe(result =>_this.router.navigate(['applications']));
  }

  cancel(){
    this.router.navigate(['applications']);
  }

  ngOnInit() {
  }

}
