import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Chart } from 'chart.js';
import { DashboardService } from '../../services/dashboard.service';
import { Data } from './dash.model';

@Component({
  selector: 'app-dash',
  templateUrl: './dash.component.html',
  styleUrls: ['./dash.component.css']
})
export class DashComponent implements OnInit {
  private token = `bearer ${localStorage.getItem('token')}`;
  hardwares: Data[];

  @ViewChild("dashGPU", { static: true }) elemento: ElementRef;

  ngOnInit() {
    this.dashService.readHardware(this.token).subscribe(xhardwares =>{
      console.log("AQUI OOOOO", xhardwares);
      this.hardwares = xhardwares['hardwares'];
    })
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
