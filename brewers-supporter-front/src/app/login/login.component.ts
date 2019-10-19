import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  invalidLogin = false;
  loading = false;
  submitted = false;

  constructor(private router: Router,
              private loginservice: AuthenticationService,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
  });
  }

  get f() { return this.loginForm.controls; }

  checkLogin() {
    this.submitted = true;

        // stop here if form is invalid
    if (this.loginForm.invalid) {
            return;
        }

    (this.loginservice.authenticate(this.f.username.value, this.f.password.value).subscribe(
      data => {
        this.router.navigate(['user'])
        this.invalidLogin = false;
      },
      error => {
        this.invalidLogin = true;

      }
    )
    );

  }

}
