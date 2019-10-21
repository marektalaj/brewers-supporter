import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

export class User{
  constructor(
    public status: string,
     ) {}
  
}

export class JwtResponse{
  constructor(
    public jwttoken: string,
     ) {}
  
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  authenticate(username, password) {
    return this.httpClient.post<any>('http://localhost:8080/authenticate', {username, password}).pipe(
     map(
       userData => {
        sessionStorage.setItem('username', username);
        let tokenStr = 'Bearer ' + userData.token;
        sessionStorage.setItem('token', tokenStr);
        return userData;
       }
     )

    );
  }
  
  existUser(username){
    return this.httpClient.get('http://localhost:8080/exists/' + username);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }

  register(user: User){
    return this.httpClient.post('http://localhost:8080/register', user)
  }

  userData(username){
    return this.httpClient.get('http://localhost:8080/user/' + username);
  }
}
