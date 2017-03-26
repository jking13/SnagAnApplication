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

  constructor(private applicationService: ApplicationService) {
    var _this = this;
    this.applicationService.getApplications(0, 20).subscribe(data =>
      _this.page = data
    );
   }

  ngOnInit() {
  }

}