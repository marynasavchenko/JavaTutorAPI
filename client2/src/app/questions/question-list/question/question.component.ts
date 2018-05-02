import { Question } from '../../question.model';
import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
  @Input() question: Question;
  @Output() questionSelected = new EventEmitter<void>();

  constructor() { }

  ngOnInit() {
  }
  
  onSelected(){
  this.questionSelected.emit();
  }

}
