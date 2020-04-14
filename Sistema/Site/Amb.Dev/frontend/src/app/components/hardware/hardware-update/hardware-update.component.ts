import { Hardware } from './../hardware.model';
import { Router, ActivatedRoute } from '@angular/router';
import { HardwareService } from './../hardware.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hardware-update',
  templateUrl: './hardware-update.component.html',
  styleUrls: ['./hardware-update.component.css']
})
export class HardwareUpdateComponent implements OnInit {

  hardware: Hardware;

  constructor(private hardwareService: HardwareService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')
    this.hardwareService.readById(id).subscribe(hardware => {
      this.hardware = hardware;
    })
  }

  updateHardware(): void {
    this.hardwareService.update(this.hardware).subscribe(() => {
      this.hardwareService.show('Produto Atualizado!')
      this.router.navigate(['/hardware'])
    })
  }

  cancel(): void {
    this.router.navigate(['/hardware'])
  }

}
