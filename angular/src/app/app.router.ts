import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { QuestionListComponent } from './component/question-list/question-list.component';
import { NewQuestionComponent } from './component/new-question/new-question.component';
import { ApplicationListComponent } from './component/application-list/application-list.component';
import { NewApplicationComponent } from './component/new-application/new-application.component';
import { HomeComponent } from './component/home/home.component'

export const router: Routes = [
	{path: '', redirectTo: 'applications', pathMatch: 'full'},
	{path: 'questions', component: QuestionListComponent},
	{path: 'questions/new', component: NewQuestionComponent},
	{path: 'applications', component: ApplicationListComponent},
	{path: 'applications/new', component: NewApplicationComponent},
	{path: 'home', component: HomeComponent}
];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);