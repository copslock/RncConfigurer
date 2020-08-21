import { Component, OnInit } from '@angular/core';
import {PeriodicElement} from '../table-main/table.component';
import {MatDialog} from '@angular/material/dialog';

let ELEMENT_DATA: Array<any>;
ELEMENT_DATA = [
  {
    id: '0',
    Rnc: 'KIER6',
  },
  {
    id: '1',
    Rnc: 'KIER7',
  }
];

@Component({
  selector: 'app-table-warning',
  templateUrl: './table-warning.component.html',
  styleUrls: ['./table-warning.component.scss']
})
export class TableWarningComponent implements OnInit {

  displayedColumns: string[] = ['id', 'Rnc', 'button'];
  dataSource = ELEMENT_DATA;

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }


}
