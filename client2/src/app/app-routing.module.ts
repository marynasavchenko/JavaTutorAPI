import { SignupComponent } from './auth/signup/signup.component';
import { QuestionDetailsComponent } from './questions/question-details/question-details.component';
import { QuestionEditComponent } from './questions/question-list/question-edit/question-edit.component';
import { QuestionStartComponent } from './questions/question-start/question-start.component';
import {NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { QuestionsComponent } from './questions/questions.component';

const appRoutes: Routes = [
{path: '', redirectTo: '/questions', pathMatch: 'full'},
  {path: 'questions', component: QuestionsComponent, children: [
  {path: '', component: QuestionStartComponent},
  {path: 'new', component: QuestionEditComponent},
    {path: ':id', component: QuestionDetailsComponent},
    {path: ':id/edit', component: QuestionEditComponent}
  ]},
  {path:'signup', component: SignupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
  
}