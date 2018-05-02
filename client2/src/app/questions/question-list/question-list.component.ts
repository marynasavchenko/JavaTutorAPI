import { Question } from '../question.model';
import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {
  
  @Output() questionWasSelected=new EventEmitter<Question>();
  questions: Question[] = [
    new Question('What is a Java object?','An object can be defined as a collection of variables and methods, which represent a complex entity, and operations relevant to that entity.'),
    new Question("Question2","Answrer2")
  ];

  constructor() { }

  ngOnInit() {
  }
  
  onQuestionSelected(question: Question){
    this.questionWasSelected.emit(question);
  
  }

}
