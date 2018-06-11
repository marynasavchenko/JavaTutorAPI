import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class AuthService {

    authenticated = false;
    token: string;

    constructor( private http: HttpClient ) { }

    signupUser( username: string, password: string ) {
        const credentials = { username, password };
        const headers = new HttpHeaders();
        headers.set( 'Content-type', 'application/json' );
        return this.http.post( '/api/signup', credentials, { headers: headers } );
    }

    signinUser( username: string, password: string ): Observable<any> {

        const data = 'username=' + encodeURIComponent( username ) +
            '&password=' + encodeURIComponent( password ) + '&submit=Login';
        const headers = new HttpHeaders().set( 'Content-Type', 'application/x-www-form-urlencoded' );

        return this.http.post( 'api/signin', data, { headers } );

    }
    
    logout(): Observable<any> {
        return this.http.post('api/logout', {}, { observe: 'response' });
        
    }
    
    isAuthenticated() {
        return this.token!=null;
    }

} 