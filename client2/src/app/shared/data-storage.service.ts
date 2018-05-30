
import {QuestionService} from '../questions/question.service';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Question } from "../questions/question.model";

@Injectable()
export class DataStorageService {

  constructor(private http: HttpClient, private questionService: QuestionService) {}

  storeQuestions() {
    return this.http.post('/api/javaquestions', this.questionService.getQuestions());
  }
  
  getQuestions() {
    this.http.get<Question []>('/api/javaquestions')
      .subscribe(
      (questions) => {
        this.questionService.setQuestions(questions);
      }
      );
  }

}