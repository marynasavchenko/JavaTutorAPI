import { Question } from '../question.model';
import { QuestionService } from '../question.service';

import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit, OnDestroy {
  questions: Question[];
  subscription: Subscription;
  
  constructor(private questionService: QuestionService,
  private router: Router,
  private route: ActivatedRoute) { }

  ngOnInit() {
    this.subscription = this.questionService.questionsChanged.subscribe(
      (questions: Question[])=>{
      this.questions=questions;
      }
    );
    this.questions=this.questionService.getQuestions();
  }
  
  onNewQuestion() {
  this.router.navigate(['new'], {relativeTo: this.route});
  }

  ngOnDestroy() {
  this.subscription.unsubscribe();
  }
}
