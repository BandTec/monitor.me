import { Router } from '@angular/router';
import { Usuario } from './usuario.model';
import { Component, OnInit } from '@angular/core';
import { Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: any = {};

  usuario : Usuario = {
    email: '',
    password: ''
  };

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user ={
      email: '',
      password: ''
    }
  }

  async signin(form){
    console.log(`entrei na função`)
    console.log(`${JSON.stringify(form.value)}`)

    const response = await this.userService.login(this.user).toPromise();
    console.log(response)
  }

  createSession(): void{
    console.log(this.usuario)
    this.userService.createSession(this.usuario).subscribe(()=>{
      this.userService.show(`Bem vindo ${this.usuario}, Logado com sucesso!`)
      this.router.navigate(['/dashboard'])
    })
  }

}