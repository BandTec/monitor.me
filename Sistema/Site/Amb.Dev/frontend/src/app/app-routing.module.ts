import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SistemaComponent } from './sistema/sistema.component';
import { InstitucionalComponent } from './components/institucional/institucional.component';


const routes: Routes = [
    //Rotas do Institucional e Login
    {
        path: "",
        component: InstitucionalComponent
    },
    // Rotas do Sistema abaixo
    {
        path: "sistema",
        component: SistemaComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule { }