import { Question } from '../question.model';
import { QuestionService } from '../question.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-question-details',
  templateUrl: './question-details.component.html',
  styleUrls: ['./question-details.component.css']
})
export class QuestionDetailsComponent implements OnInit {
  question: Question;
  id: number;

  constructor(private questionService: QuestionService, 
    private route: ActivatedRoute,
  private router: Router) { }

  ngOnInit() {
    this.route.params
      .subscribe(
        (params: Params)=>{
        this.id=+params['id'];
          this.question=this.questionService.getQuestion(this.id);
        }
      );
   }
  
  onEditQuestion() {
  this.router.navigate(['edit'], {relativeTo: this.route});
  }
  
  onDeleteQuestion() {
  this.questionService.deleteQuestion(this.id);
    this.router.navigate(['/questions'], {relativeTo: this.route});
  }

}
