import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { RedDirective } from './directives/red.directive';
import { SistemaModule } from './sistema/sistema.module';
import { InstitucionalModule } from './institucional/institucional.module';




@NgModule({
  declarations: [
    AppComponent,
    RedDirective,    
  ],
  imports: [
    AppRoutingModule,
    SistemaModule,
    InstitucionalModule,
    BrowserModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
