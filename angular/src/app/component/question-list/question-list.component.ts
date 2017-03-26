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

  constructor(private questionService: QuestionService) {
    this.refresh();
   }

   refresh(){
     var _this = this;
    this.questionService.getQuestions(0, 20).subscribe(data =>
      _this.page = data
    );
   }

   delete(id){
     var _this = this;
    this.questionService.deleteQuestion(id).subscribe(data =>
      _this.refresh()
    );
   }

  ngOnInit() {
  }

}
