import {Question} from './question.model';
import { EventEmitter } from '@angular/core';
import { Subject } from 'rxjs/Subject';

export class QuestionService {
  questionsChanged = new Subject <Question[]>();
  
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

  addQuestion(question: Question) {
    this.questions.push(question);
    this.questionsChanged.next(this.questions.slice());
  }

  updateQuestion(index: number, newQuestion: Question) {
    this.questions[index]= newQuestion;
    this.questionsChanged.next(this.questions.slice());
  }

}