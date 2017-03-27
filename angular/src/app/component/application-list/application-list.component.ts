import { Component, OnInit, Input } from '@angular/core';
import { ApplicationService } from '../../service/application.service';
import { Application } from '../../model/application';
import { Page } from '../../model/page';


@Component({
  selector: 'app-application-list',
  templateUrl: './application-list.component.html',
  styleUrls: ['./application-list.component.css'],
  providers: [ApplicationService]
})
export class ApplicationListComponent implements OnInit {

  page: Page<Application>;
  searchTerm: string = '';

  constructor(private applicationService: ApplicationService) {
     this.refresh(0)
   }

   refresh(pageNumber){
     var _this = this;
    this.applicationService.getApplications(pageNumber, 10, this.searchTerm).subscribe(data =>
      _this.page = data
    );
   }

   searchChange(event) {
     this.searchTerm = event;
     this.refresh(0);
   }

   pageNumberChange(event) {
     this.refresh(event);
   }

   delete(id){
     var _this = this;
    this.applicationService.deleteApplication(id).subscribe(data =>
      _this.refresh(0)
    );
   }

  ngOnInit() {
  }

}
