import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AuthService {

    authenticated = false;

    constructor( private http: HttpClient ) { }

    signupUser( username: string, password: string ) {
        const credentials = { username, password };
        var headers = new HttpHeaders();
        headers.set( 'Content-type', 'application/json' );
        return this.http.post( '/api/signup', credentials, { headers: headers } );
    }

    signinUser( username: string, password: string ) {
        const credentials = { username, password };
        const headers = new HttpHeaders( credentials ? {
            authorization: 'Basic ' + btoa( credentials.username + ':' + credentials.password )
        } : {} );
        
        return this.http.post( '/api/signin', credentials, { headers: headers } );
     
    }

    /*authenticate( credentials ) {
        const headers = new HttpHeaders( credentials ? {
            authorization: 'Basic ' + btoa( credentials.username + ':' + credentials.password )
        } : {} );

        this.http.get( 'account', { headers: headers } ).subscribe( response => {
            if ( response['name'] ) {
                this.authenticated = true;
            } else {
                this.authenticated = false;
            }
        });
    }*/
} 