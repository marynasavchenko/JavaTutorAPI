import {AuthService} from '../auth.service';
import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
//import {Response} from '@angular/common/http';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
    error: String;

  constructor(private authService: AuthService, private route: ActivatedRoute,
          private router: Router) {}

  ngOnInit() {
  }

  onSignin( form: NgForm ) {
      const username = form.value.username;
      const password = form.value.password;
      this.authService.signinUser( username, password ).subscribe
      (next => {
          this.router.navigate(['../'], {relativeTo: this.route})
               }, error => {
                  this.error = "Bad credentials"; 
               });
      
     
  }

}
