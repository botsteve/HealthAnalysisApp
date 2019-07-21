import { MyprofileComponent } from './myprofile/myprofile.component';
import { EkgComponent } from './ekg/ekg.component';
import { TemperatureComponent } from './temperature/temperature.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmgComponent } from './emg/emg.component';
import { GpsComponent } from './gps/gps.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'temperature', component: TemperatureComponent},
  { path: 'ekg', component: EkgComponent},
  { path: 'emg', component: EmgComponent},
  { path: 'gps', component: GpsComponent},
  { path: 'myprofile', component:MyprofileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
