import {QuestionService} from '../../question.service';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {ActivatedRoute, Params} from '@angular/router';

@Component({
  selector: 'app-question-edit',
  templateUrl: './question-edit.component.html',
  styleUrls: ['./question-edit.component.css']
})
export class QuestionEditComponent implements OnInit {
  id: number;
  editMode = false;
  questionForm: FormGroup;

  constructor(private route: ActivatedRoute, private questionService: QuestionService) {}

  ngOnInit() {
    this.route.params
      .subscribe(
      (params: Params) => {
        this.id = +params['id'];
        this.editMode = params['id'] != null;
        this.initForm(); 
      }
      );
  }
  
  onSubmit() {
    
  }
  
  private initForm() {
    let javaQuestion = '';
    let javaAnswer = '';

    if (this.editMode) {
      const question = this.questionService.getQuestion(this.id);
      javaQuestion = question.question;
      javaAnswer = question.answer;
    }

    this.questionForm = new FormGroup({
      'question': new FormControl(javaQuestion, Validators.required),
      'answer': new FormControl(javaAnswer, Validators.required)
    });
  }

}
