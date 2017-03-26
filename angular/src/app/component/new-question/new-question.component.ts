import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { QuestionService } from '../../service/question.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-new-question',
  templateUrl: './new-question.component.html',
  styleUrls: ['./new-question.component.css'],
  providers: [QuestionService]
})
export class NewQuestionComponent implements OnInit {

  public newQuestionForm = this.fb.group({
    question: ["", Validators.required],
    answer: ["", Validators.required]
  });

  constructor(public fb: FormBuilder,
  				private questionService: QuestionService,
  				private router: Router) { 

  }

  ngOnInit() {
  }

  doSave(event) {
    console.log(this.newQuestionForm.value);
    var _this = this;
    this.questionService.saveQuestion(this.newQuestionForm.value)
    .subscribe(result =>_this.router.navigate(['questions']));
  }

  cancel(){
  	this.router.navigate(['questions']);
  }

}
