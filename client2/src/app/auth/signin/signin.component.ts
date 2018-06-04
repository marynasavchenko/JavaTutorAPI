import {AuthService} from '../auth.service';
import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
//import {Response} from '@angular/common/http';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private authService: AuthService) {}

  ngOnInit() {
  }

  onSignin( form: NgForm ) {
      const username = form.value.username;
      const password = form.value.password;
      this.authService.signinUser( username, password ).subscribe(
          ( response) => {
              console.log( response + username );
          }
      );
  }

}
