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

  // usuario : Usuario = {
  //   email: '',
  //   password: ''
  // };

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = {
      name: '',
      email: '',
      password: ''
    }
  }

  async signin(form) {

    try {
      console.log(`${JSON.stringify(form.value)}`)



      const response = await this.userService.login(this.user).toPromise();
      console.log(response)

      if (response['token']) {
        const token = response['token'];

        localStorage.setItem('token', token);

        this.userService.show('token: ' + token)
        // console.log('token: ' + token)

        this.userService.show(`Bem vindo, Logado com sucesso!`)
        this.router.navigate(['/sistema/dashboard'])

        return
      }
    } catch (err) {
      console.log('Error:', err)
    }

    return this.userService.show(`Login Inválido!`);
  }

  // createSession(): void{
  //   console.log(this.usuario)
  //   this.userService.createSession(this.usuario).subscribe(()=>{
  //     this.userService.show(`Bem vindo ${this.usuario}, Logado com sucesso!`)
  //     this.router.navigate(['/dashboard'])
  //   })
  // }

}