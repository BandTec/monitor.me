import { Injectable } from '@angular/core';

import { CanActivate, Router } from '@angular/router'

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private router: Router) { }

  canActivate(){
    
    console.log(localStorage.getItem('token'))
    const token = localStorage.getItem('token') || null;
    console.log(token)

    if(token != null){
      return true;
    }

    this.router.navigate(['/home/login'])

    return false;

  }

}
