import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule, JsonpModule, RequestOptions } from '@angular/http';

import { AppComponent } from './component/app.component';
import { ApplicationComponent } from './component/application/application.component';
import { QuestionComponent } from './component/question/question.component';
import { QuestionListComponent } from './component/question-list/question-list.component';
import { ApplicationListComponent } from './component/application-list/application-list.component';

import { routes } from './app.router';
import { HomeComponent } from './component/home/home.component';
import { NewApplicationComponent } from './component/new-application/new-application.component';
import { NewQuestionComponent } from './component/new-question/new-question.component';
import { PagerComponent } from './component/pager/pager.component';
import { SearchBarComponent } from './component/search-bar/search-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    ApplicationComponent,
    QuestionComponent,
    QuestionListComponent,
    ApplicationListComponent,
    HomeComponent,
    NewApplicationComponent,
    NewQuestionComponent,
    PagerComponent,
    SearchBarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    ReactiveFormsModule,
    routes
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
