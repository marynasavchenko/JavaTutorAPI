import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AuthService {

    authenticated = false;

    constructor( private http: HttpClient ) { }

    signupUser( username: string, password: string ) {
        const credentials = { username, password };
        const headers = new HttpHeaders();
        headers.set( 'Content-type', 'application/json' );
        return this.http.post( '/api/signup', credentials, { headers: headers } );
    }

    signinUser( username: string, password: string ) {
        const credentials = { username, password };
        const headers = new HttpHeaders();
        headers.set( 'Content-type', 'application/json' );
        headers.set( 'Authorization', 'my-auth-token' );
        return this.http.post( '/api/signin', credentials, { headers: headers } )
        //.pipe(catchError(this.handleError())
    ;
     
    }

} 