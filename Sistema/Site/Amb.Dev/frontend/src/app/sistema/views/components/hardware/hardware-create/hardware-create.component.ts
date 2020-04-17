import { Hardware } from './../hardware.model';
import { Router } from '@angular/router';
import { HardwareService } from '../../../services/hardware.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hardware-create',
  templateUrl: './hardware-create.component.html',
  styleUrls: ['./hardware-create.component.css']
})
export class HardwareCreateComponent implements OnInit {

  hardware: Hardware = {
    modelo: '',
    GPU: '',
    hardDisk: '',
    memoryRam: ''
  }

  constructor(private hardwareService: HardwareService, private router: Router) { }

  ngOnInit(): void {
    
  }

  createHardware(): void{
    this.hardwareService.createHardware(this.hardware).subscribe(()=>{
      this.hardwareService.show('Hardware Inserido com sucesso!')
      this.router.navigate(['/hardware'])
    });
  }

  cancel():void {
    this.router.navigate(['/hardware'])
  }
}
