import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { QuestionsComponent } from './questions/questions.component';
import { QuestionListComponent } from './questions/question-list/question-list.component';
import { QuestionComponent } from './questions/question-list/question/question.component';
import { QuestionEditComponent } from './questions/question-list/question-edit/question-edit.component';
import { QuestionDetailsComponent } from './questions/question-details/question-details.component';
import { DropdownDirective } from './shared/dropdown.directive';
import { QuestionStartComponent } from './questions/question-start/question-start.component';
import { QuestionService } from './questions/question.service';
import { DataStorageService } from './shared/data-storage.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { SignupComponent } from './auth/signup/signup.component';
import { SigninComponent } from './auth/signin/signin.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    QuestionsComponent,
    QuestionListComponent,
    QuestionComponent,
    QuestionEditComponent,
    QuestionDetailsComponent,
    DropdownDirective,
    QuestionStartComponent,
    SignupComponent,
    SigninComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule
  ],
  providers: [QuestionService, DataStorageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
