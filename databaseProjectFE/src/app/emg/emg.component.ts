import { EmgService } from './../services/emg.service';
import { Component, OnInit } from '@angular/core';
import { EMG } from '../model/emg';

@Component({
  selector: 'app-emg',
  templateUrl: './emg.component.html',
  styleUrls: ['./emg.component.css']
})
export class EmgComponent implements OnInit {

  rowData: EMG[] = [];
  newVoltage: number;
  data: any;
  options: any;
  timeValues: Date[] = [];
  voltageValues: number[] = [];


  columnDefs = [
    { headerName: 'Voltage Value', field: 'voltageValue', sortable: true, enableRowGroup: true, resizable: true },
    { headerName: 'Time Value', field: 'timeValue', sortable: true, enableRowGroup: true, resizable: true }
  ];


  constructor(private emgService: EmgService) {
  }

  ngOnInit() {
    this.getEMG();
    console.log(this.voltageValues);
  }

  getEMG() {
    this.emgService.getEmgForUser().subscribe(response => {
      this.rowData = response;
      console.log(this.rowData);
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
    this.getEMG();
  }

  insertNewEMG(newVoltage: number){
    this.newVoltage = newVoltage;
    console.log(this.newVoltage);
    this.emgService.insertNewEMG(this.newVoltage).subscribe(resp => {
      console.log(resp);
    });
  }
}
