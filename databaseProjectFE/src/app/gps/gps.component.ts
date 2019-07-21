import { GPS } from './../model/gps';
import { GpsService } from './../services/gps.service';
import { Component, Input, ViewChild, NgZone, OnInit } from '@angular/core';
import { MapsAPILoader, AgmMap } from '@agm/core';
import { GoogleMapsAPIWrapper } from '@agm/core/services';

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
  latitude: number;
  longitude: number;
  isLoaded: boolean = false;


  columnDefs = [
    { headerName: 'Latitude Value', field: 'latitude', sortable: true, filter: true, resizable: true },
    { headerName: 'Longitude Value', field: 'longitude', sortable: true, filter: true, resizable: true },
    { headerName: 'Altitude Value', field: 'altitude', sortable: true, filter: true, resizable: true },
    { headerName: 'Time Value', field: 'timeValue', sortable: true, filter: true, resizable: true }
  ];


  constructor(private gpsService: GpsService, public mapsApiLoader: MapsAPILoader,
    private zone: NgZone,
    private wrapper: GoogleMapsAPIWrapper) {
    this.mapsApiLoader = mapsApiLoader;
    this.zone = zone;
    this.wrapper = wrapper;
    this.mapsApiLoader.load().then(() => {
      this.getGpsLocations();
    });

  }

  ngOnInit() {
  }

  async getGpsLocations() {
    await this.gpsService.getGpsLocationForUser().toPromise().then(response => {
      this.rowData = response
      if(this.rowData[this.rowData.length - 1] == undefined){
        return;
      }
        console.log(this.rowData + " " + this.rowData[this.rowData.length - 1].latitude + " " + this.rowData[this.rowData.length - 1].longitude);
        this.latitude = this.rowData[this.rowData.length - 1].latitude;
        this.longitude = this.rowData[this.rowData.length - 1].longitude;
    });
    this.getOptionsAndOverlays();
    this.isLoaded = true;
  }


  onGridReady(params) {
    params.api.sizeColumnsToFit();
  }

  updateValues() {
    this.rowData = [];
    this.getGpsLocations();
    window.location.reload();
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

    this.overlays = [
      new google.maps.Marker({ position: { lat: Number(this.latitude), lng: Number(this.longitude) }, title: "test" }),
    ];

    this.options = {
      // center: { lat: 44.43551, lng: 26.05427 },
      center: { lat: Number(this.latitude), lng: Number(this.longitude) },
      zoom: 16
    };

    console.log("OPTIONS : " + this.options.center.lat + " " + this.options.center.lng);
    console.log("OVERLAYS :" + this.overlays[0].position);
  }

}
