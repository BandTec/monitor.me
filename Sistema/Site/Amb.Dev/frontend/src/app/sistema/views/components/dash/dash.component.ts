import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Chart } from 'chart.js';
import { DashboardService } from '../../services/dashboard.service';
import { DataJson } from 'src/app/models/dataHard.models';

@Component({
  selector: 'app-dash',
  templateUrl: './dash.component.html',
  styleUrls: ['./dash.component.css']
})
export class DashComponent implements OnInit {
  private token = `bearer ${localStorage.getItem('token')}`;
  dataFromApi: DataJson[];
  sttsCpu: any[];

  @ViewChild("dashGPU", { static: true }) elemento: ElementRef;

  ngOnInit() {
    this.dashService.readHardware(this.token).subscribe((data) =>{
      console.log(data)
      this.dataFromApi = data['dadosHardware'];
      console.log("data>>> ",this.dataFromApi)

      this.sttsCpu = this.dataFromApi.map((x) => {
      console.log("Processador",x.cpuDados['getNomeProc'])
      console.log("MemoriaController da Gpu", x.gpuDados['memoriaCtrlGpu'])
      })
      
    }, error => {
      console.log(error);
    });
    new Chart(this.elemento.nativeElement, {
      type: "line",
      data: {
        labels: ["11-10-2019", "11-10-2019", "11-10-2019", "11-10-2019", "11-10-2019", "11-10-2019"],
        datasets: [
          {
            label: 'Alerta em Graus ºC',
            data: [12, 34, 55, 66, 13, 100],
            borderColor: '#7b1fa2',
            fill: false
          }
        ],
      }
    });
  }


  /** Based on the screen size, switch from standard to one column per row */
  cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { title: 'Sua GPU', cols: 1, rows: 1 },
          { title: 'Card 2', cols: 1, rows: 1 },
          { title: 'Card 3', cols: 1, rows: 1 },
          { title: 'Card 4', cols: 1, rows: 1 }
        ];
      }

      return [
        { title: 'Sua GPU', cols: 2, rows: 1 },
        { title: 'Card 2', cols: 1, rows: 1 },
        { title: 'Card 3', cols: 1, rows: 2 },
        { title: 'Card 4', cols: 1, rows: 1 }
      ];
    })
  );

  constructor(private breakpointObserver: BreakpointObserver, private dashService: DashboardService) { }
}
