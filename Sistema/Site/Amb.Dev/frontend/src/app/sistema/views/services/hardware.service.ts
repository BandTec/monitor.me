import { Hardware } from '../components/hardware/hardware.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HardwareService {

  baseCadastro = "http://localhost:3333/cadastrar/1/novoHardware"
  baseConsulta = "http://localhost:3333/1/eventMyHardware/1/AllH"

  constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

  show(msg: string){
    this.snackBar.open(msg, 'X', {
      duration: 2000,
      horizontalPosition: "right",
      verticalPosition: "bottom"
    })
  }

  createHardware(hardware: Hardware): Observable<Hardware> {
    return this.http.post<Hardware>(this.baseCadastro, hardware)
  }

  readHardware(): Observable<Hardware[]>{
    // console.log(this.http.get<Hardware[]>(this.baseConsulta))
    return this.http.get<Hardware[]>(this.baseConsulta)
  }

  readById(id: string): Observable<Hardware>{
    const url = `${this.baseConsulta}/${id}` 
    return this.http.get<Hardware>(url);
  }

  update(hardware: Hardware): Observable<Hardware>{
    const url = `${this.baseConsulta}/${hardware.id}` 
    console.log('>>', url)
    return this.http.put<Hardware>(url, hardware);
  } 
}
