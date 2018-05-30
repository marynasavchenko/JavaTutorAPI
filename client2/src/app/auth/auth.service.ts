import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) {}

  signupUser(username: string, password: string) {
    const body = {username, password};
    var headers = new HttpHeaders();
    headers.set('Content-type', 'application/json');
    return this.http.post('/api/signup', body, {headers: headers});
  }

  signinUser(username: string, password: string) {
      const body = {username, password};
      var headers = new HttpHeaders();
      headers.set('Content-type', 'application/json');
      return this.http.post('/api/signin', body, {headers: headers});
  }
}