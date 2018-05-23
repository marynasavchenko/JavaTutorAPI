import { Question } from '../question.model';
import { QuestionService } from '../question.service';

import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {
  questions: Question[];
  
  constructor(private questionService: QuestionService,
  private router: Router,
  private route: ActivatedRoute) { }

  ngOnInit() {
    this.questions=this.questionService.getQuestions();
  }
  
  onNewQuestion() {
  this.router.navigate(['new'], {relativeTo: this.route});
  }

}
