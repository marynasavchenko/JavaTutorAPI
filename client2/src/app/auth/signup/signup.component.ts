import { AuthService } from '../auth.service';
import { Component, OnInit, Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Response} from '@angular/http';

@Injectable()
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  onSignup(form: NgForm) {
    const username= form.value.username;
    const password= form.value.password;
    this.authService.signupUser(username, password)
      .subscribe(
        (response: Response)=>{
        console.log(response);
        }
    );
  
  }
}
