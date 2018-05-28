
import {QuestionService} from '../questions/question.service';
import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';

@Injectable()
export class DataStorageService {

  constructor(private http: Http, private questionService: QuestionService) {}

  storeQuestions() {
    return this.http.post('/javaquestions', this.questionService.getQuestions());
  }
  
  getQuestions() {
    this.http.get('/javaquestions')
      .subscribe(
      (response: Response) => {
        const questions = response.json();
        this.questionService.setQuestions(questions);
      }
      );
  }

}