import { SiteMainComponent } from './institucional/site-main/site-main.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SistemaComponent } from './sistema/sistema.component';
import { InstitucionalComponent } from './institucional/institucional.component';


const routes: Routes = [
    //Rotas do Institucional e Login
    {
        path: "",
        component: InstitucionalComponent,
        children: [
            {
                path: "home",
                component: SiteMainComponent,
            }
        ]
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