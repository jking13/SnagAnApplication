import { Component, OnInit, Input } from '@angular/core';
import { QuestionService } from '../../service/question.service';
import { Question } from '../../model/question';
import { Page } from '../../model/page';


@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css'],
  providers: [QuestionService]
})
export class QuestionListComponent implements OnInit {

  page: Page<Question>;
  searchTerm: string = '';

  constructor(private questionService: QuestionService) {
    this.refresh(0);
   }

   refresh(pageNumber){
     var _this = this;
    this.questionService.getQuestions(pageNumber, 10, this.searchTerm).subscribe(data =>
      _this.page = data
    );
   }

   pageNumberChange(event) {
     this.refresh(event);
   }

   searchChange(event) {
     this.searchTerm = event;
     this.refresh(0);
   }

   delete(id){
     var _this = this;
    this.questionService.deleteQuestion(id).subscribe(data =>
      _this.refresh(0)
    );
   }

  ngOnInit() {
  }

}
