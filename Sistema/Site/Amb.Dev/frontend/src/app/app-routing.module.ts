import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HardwareComponent } from './views/main/hardware/hardware.component';
import { DashboardComponent } from './views/main/dashboard/dashboard.component';
import { HardwareCreateComponent } from './components/hardware/hardware-create/hardware-create.component';
import { PerfilComponent } from './views/main/perfil/perfil.component';
import { HardwareUpdateComponent } from './components/hardware/hardware-update/hardware-update.component';

const routes: Routes = [
    {
        path: "dashboard",
        component: DashboardComponent
    },
    {
        path: "hardware",
        component: HardwareComponent
    },
    {
        path: "perfil",
        component: PerfilComponent
    },
    {
        path: "hardware/hardware-create",
        component: HardwareCreateComponent
    },
    {
        path: "hardware/hardware-update/:id",
        component: HardwareUpdateComponent
    },

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule { }