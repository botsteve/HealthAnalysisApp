import { GPS } from './../model/gps';
import { GpsService } from './../services/gps.service';
import { Component, OnInit } from '@angular/core';
declare var google: any;
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
  overlays: any[];


  columnDefs = [
    { headerName: 'Latitude Value', field: 'latitude', sortable: true, enableRowGroup: true, resizable: true },
    { headerName: 'Longitude Value', field: 'longitude', sortable: true, enableRowGroup: true, resizable: true },
    { headerName: 'Altitude Value', field: 'altitude', sortable: true, enableRowGroup: true, resizable: true },
    { headerName: 'Time Value', field: 'timeValue', sortable: true, enableRowGroup: true, resizable: true }
  ];


  constructor(private gpsService: GpsService) {

  }

  ngOnInit() {
    this.getGpsLocations();

  }

  async getGpsLocations() {
    this.gpsService.getGpsLocationForUser().subscribe(response => {
      this.rowData = response;
      console.log(this.rowData);
      this.getOptionsAndOverlays();
    });
  }


  onGridReady(params) {
    params.api.sizeColumnsToFit();
  }

  updateValues() {
    // this.rowData = [];
    // this.getGpsLocations();
    this.getOptionsAndOverlays();
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

  getOptionsAndOverlays() {
    this.options = {
      center: { lat: this.rowData[0].latitude, lng: this.rowData[0].longitude },
      zoom: 12
    };

    this.overlays = [
      // new google.maps.Marker({ position: { lat: this.rowData[0].latitude, lng: this.rowData[0].longitude }, title: "Konyaalti" }),
    ];

    console.log(this.options);
    console.log(this.overlays);
  }
}
