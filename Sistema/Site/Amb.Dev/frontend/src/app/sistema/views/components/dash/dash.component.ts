import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Chart } from 'chart.js';
import { DashboardService } from '../../services/dashboard.service';
import { DataJson } from 'src/app/models/dataHard.models';

@Component({
  selector: 'app-dash',
  templateUrl: './dash.component.html',
  styleUrls: ['./dash.component.css'],
})
export class DashComponent implements OnInit {
  private token = `bearer ${localStorage.getItem('token')}`;

  userLogado = `${localStorage.getItem('name')}`;
  dataFromApi: DataJson[];
  sttsHardware: any;
  hardResult: any;
  nomeProcessador: any;
  public ArrayTempGpu: Array<number>;
  public ArrayData: Array<number>;
  TempMediaGpu: number;
  
  @ViewChild('dashGPU', { static: true }) elemento: ElementRef;

  ngOnInit() {
    this.dashService.readHardware(this.token).subscribe(
      (data) => {
        this.dataFromApi = data['dadosHardware'];
        console.log('data>>> ', this.dataFromApi);
        const apiTempGpu = [];
        const apiDataGpu = [];
        this.sttsHardware = this.dataFromApi.map((x) => {
          
          const dadosRecebidos = {
            cpu: x.cpuDados,
            gpu: x.gpuDados,
            oshi: x.oshiDados,
            data: x.ctDDados
          };
          this.hardResult = dadosRecebidos;          
          
          apiTempGpu.push(this.hardResult['gpu']['temperaturaMedia']);
          apiDataGpu.push(this.hardResult['data'])
          
          this.ArrayTempGpu = apiTempGpu;
          this.ArrayData = apiDataGpu;

          return dadosRecebidos;
        });

        //Setar abaixo as variaveis que irao aparecer no front
        this.nomeProcessador = this.hardResult['cpu']['getNomeProc'];

        console.log(">>>>",this.ArrayTempGpu);

        new Chart(this.elemento.nativeElement, {
          type: 'line',
          data: {
            labels: this.ArrayData,
            datasets: [
              {
                label: 'Alerta em Graus ºC',
                data: this.ArrayTempGpu,
                borderColor: '#7b1fa2',
                fill: true,
              },
            ],
          },
        });
      },
      (error) => {
        console.log(error);
      }
    );
  }
  constructor(
    private breakpointObserver: BreakpointObserver,
    private dashService: DashboardService
  ) {}
}
