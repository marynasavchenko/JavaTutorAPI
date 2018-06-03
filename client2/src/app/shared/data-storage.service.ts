
import {QuestionService} from '../questions/question.service';
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Question } from "../questions/question.model";

@Injectable()
export class DataStorageService {

  constructor(private http: HttpClient, private questionService: QuestionService) {}

  storeQuestions() {
      console.log(this.questionService.getQuestions());
      var headers = new HttpHeaders();
      headers.set('Content-type', 'application/json');
    return this.http.post('/api/javaquestions', this.questionService.getQuestions(), {headers: headers});
    
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