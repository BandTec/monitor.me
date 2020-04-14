import { HardwareService } from './../hardware.service';
import { Hardware } from './../hardware.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hardware-read',
  templateUrl: './hardware-read.component.html',
  styleUrls: ['./hardware-read.component.css']
})
export class HardwareReadComponent implements OnInit {

  hardwares: Hardware[]
  displayedColumns = ['modelo', 'memoryRam', 'GPU', "hardDisk", "action"];

  constructor(private hardwareService: HardwareService) { }

  ngOnInit(): void {
    this.hardwareService.readHardware().subscribe(hardwares =>{
      this.hardwares = hardwares
      console.log(hardwares)
    })
  }

}
