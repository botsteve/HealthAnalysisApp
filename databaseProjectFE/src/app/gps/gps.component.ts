import { GPS } from './../model/gps';
import { GpsService } from './../services/gps.service';
import { Component, OnInit } from '@angular/core';
import { stringify } from 'querystring';
import { EMG } from '../model/emg';

@Component({
  selector: 'app-gps',
  templateUrl: './gps.component.html',
  styleUrls: ['./gps.component.css']
})
export class GpsComponent implements OnInit {
  rowData: GPS[] = [];
  newGpsLocation: GPS = new GPS();
  timeValues: Date[] = [];
  options: any;
  lat: number = 51.678418;
  lng: number = 7.809007;


  columnDefs = [
    { headerName: 'Latitude Value', field: 'latitude', sortable: true, enableRowGroup: true, resizable: true },
    { headerName: 'Longitude Value', field: 'longitude', sortable: true, enableRowGroup: true, resizable: true },
    { headerName: 'Altitude Value', field: 'altitude', sortable: true, enableRowGroup: true, resizable: true },
    { headerName: 'Time Value', field: 'timeValue', sortable: true, enableRowGroup: true, resizable: true }
  ];


  constructor(private gpsService: GpsService) {
    this.options = {
      center: { lat: 36.890257, lng: 30.707417 },
      zoom: 12
    };
  }

  ngOnInit() {
    this.getGpsLocations();

  }

  getGpsLocations() {
    this.gpsService.getGpsLocationForUser().subscribe(response => {
      this.rowData = response;
      // response.forEach(e => {
      //   let location: string;
      //   location = e.latitude.toString() + ',' + e.longitude.toString() + ',' + e.altitude.toString();
      //   const timeValue = e.timeValue;
      //   this.rowData.push({ location, timeValue});
      // });
      console.log(this.rowData);
    });
  }


  onGridReady(params) {
    params.api.sizeColumnsToFit();
  }

  updateValues() {
    this.rowData = [];
    this.getGpsLocations();
  }

  insertNewGpsLocation(newLatitute: number, newLongitude: number, newAltitude: number) {
    this.newGpsLocation.latitude = newLatitute;
    this.newGpsLocation.longitude = newLongitude;
    this.newGpsLocation.altitude = newAltitude;
    console.log(this.newGpsLocation);
    this.gpsService.insertNewGPSLocation(this.newGpsLocation).subscribe(resp => {
      console.log(resp);
    });
  }
}
