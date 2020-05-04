import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  public user : any = {};

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = {
      name: '',
      email: '',
      whatsapp: '',
      password: '',
    }


  }

  async signup(form) {

    try {
      console.log(`${JSON.stringify(form.value)}`)
      const response = await this.userService.cadastrar(this.user).toPromise();
      console.log(response)
      if (response['token']) {
        const token = response['token'];
        const id = response['user']['id'];
        const contato = response['user']['whatsapp']
        const name = response['user']['name']
        const email = response['user']['email']

        localStorage.setItem('token', token);
        localStorage.setItem('id', id);
        localStorage.setItem('name', name);
        localStorage.setItem('contato', contato);
        localStorage.setItem('contato', email);
        

        this.userService.show(`Bem vindo, Logado com sucesso!`)

        this.router.navigate(['/sistema/dashboard'])

        this.userService.show('Bem vindo, é bom te ter aqui... ' + name)

        return
      }
    } catch (err) {
      console.log('Error:', err)
    }

    return this.userService.show(`Login Inválido!`);
  }

}
