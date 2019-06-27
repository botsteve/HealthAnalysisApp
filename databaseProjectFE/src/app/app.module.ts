import { UserService } from './services/user.service';
import { MessageService } from 'primeng/api';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AccordionModule } from 'primeng/components/accordion/accordion';
import { PanelModule } from 'primeng/components/panel/panel';
import { ButtonModule } from 'primeng/components/button/button';
import { RadioButtonModule } from 'primeng/components/radioButton/radioButton';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ToastModule } from 'primeng/toast';
import { TopNavComponent } from './common/top-nav/top-nav.component';
import { TemperatureComponent } from './temperature/temperature.component';
import { TableModule } from 'primeng/table';
import { AgGridAngular, AgGridColumn, AgGridModule } from 'ag-grid-angular';
import { ChartModule } from 'primeng/chart';
import { EkgComponent } from './ekg/ekg.component';
import { EmgComponent } from './emg/emg.component';
import { GpsComponent } from './gps/gps.component';
import { AgmCoreModule } from '@agm/core';
import { GMapModule } from 'primeng/gmap';
import { RegisterComponent } from './register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    TopNavComponent,
    TemperatureComponent,
    EkgComponent,
    EmgComponent,
    GpsComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    PanelModule,
    ButtonModule,
    RadioButtonModule,
    AccordionModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ToastModule,
    TableModule,
    AgGridModule,
    ChartModule,
    GMapModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBJLord40d1O65ZjSdH4BqTpj_85c5v7Yw'
    })
  ],
  providers: [MessageService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
