import { EKG } from './../model/ekg';
import { EkgService } from './../services/ekg.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ekg',
  templateUrl: './ekg.component.html',
  styleUrls: ['./ekg.component.css']
})
export class EkgComponent implements OnInit {
  rowData: EKG[] = [];
  newVoltage: number;
  data: any;
  options: any;
  timeValues: Date[] = [];
  voltageValues: number[] = [];


  columnDefs = [
    { headerName: 'Voltage Value', field: 'voltageValue', sortable: true, enableRowGroup: true, resizable: true },
    { headerName: 'Time Value', field: 'timeValue', sortable: true, enableRowGroup: true, resizable: true }
  ];


  constructor(private ekgService: EkgService) {
  }

  ngOnInit() {
    this.getEKG();
    console.log(this.voltageValues);
  }

  getEKG() {
    this.ekgService.getEkgForUser().subscribe(response => {
      this.rowData = response;
      this.getValuesForChart();
      this.assignValuesToChart();
    })
  }

  getValuesForChart() {
    this.timeValues = [];
    this.voltageValues = [];
    this.rowData.forEach(element => {
      this.timeValues.push(element.timeValue);
      this.voltageValues.push(element.voltageValue);
    });
  }

  assignValuesToChart() {
    this.data = {
      labels: this.timeValues,
      datasets: [
        {
          label: 'Temperatures Values',
          data: this.voltageValues
        }
      ]
    }

    this.options = {
      title: {
        display: true,
        text: 'Graph',
        fontSize: 16
      },
      legend: {
        position: 'bottom'
      }
    };
  }

  onGridReady(params) {
    params.api.sizeColumnsToFit();
  }

  updateValues(){
    this.getEKG();
  }

  insertNewEKG(newVoltage: number){
    this.newVoltage = newVoltage;
    console.log(this.newVoltage);
    this.ekgService.insertNewEKG(this.newVoltage).subscribe(resp => {
      console.log(resp);
    });
  }
}
