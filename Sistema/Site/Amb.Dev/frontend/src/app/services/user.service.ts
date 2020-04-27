import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../institucional/login/usuario.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { EventEmitter } from 'events';

const ApiRoutes = {
  login: 'sessions',
  signup: 'signup',
  users: 'users'
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private UrlApi = "http://localhost:3333"
  baseConsultaLogin = "http://localhost:3333/sessions";

  constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

  public login(user : any){
    let url = `${this.UrlApi}/${ApiRoutes.login}`;

    return this.http.post(url, JSON.stringify(user), this.loadHeaders())
  }

  private loadHeaders (token: string = ''){
    let headers = new HttpHeaders({
      'Content-type': 'application/json',
      'Authorization': `${token}`
      //poderia usar o id do user 
    });

    return { headers };
  }

  show(msg: string){
    this.snackBar.open(msg, 'X', {
      duration: 2000,
      horizontalPosition: "right",
      verticalPosition: "bottom"
    })
  }
  createSession(usuario: Usuario ): Observable<Usuario>{
    return this.http.post<Usuario>(this.baseConsultaLogin, usuario)
  }

}
