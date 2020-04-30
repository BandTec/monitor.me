import { UserService } from './../../../services/user.service';
import { Hardware } from '../components/hardware/hardware.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  urlApiSistema = "http://localhost:3333/sistema"

  constructor(private snackBar: MatSnackBar) { }

  show(msg: string){
    this.snackBar.open(msg, 'X', {
      duration: 2000,
      horizontalPosition: "right",
      verticalPosition: "bottom"
    })
  }
}
