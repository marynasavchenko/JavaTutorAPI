import {Question} from './question.model';
import { EventEmitter } from '@angular/core';

export class QuestionService {
  questionSelected = new EventEmitter<Question>();
  
  private questions: Question[] = [
    new Question('What is a Java object?', 'An object can be defined as a collection of variables and methods, which represent a complex entity, and operations relevant to that entity.'),
    new Question("Question2", "Answrer2")
  ];

  getQuestions() {
    return this.questions.slice();
  }
  
  getQuestion(index: number) {
  return this.questions[index];
  }

}