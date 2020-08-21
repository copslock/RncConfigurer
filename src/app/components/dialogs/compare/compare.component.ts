import { Component, OnInit } from '@angular/core';
import {TableComponent} from '../../table/table-main/table.component';

@Component({
  selector: 'app-compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.scss']
})
export class CompareComponent implements OnInit {

  objects = TableComponent.objects;

  constructor() { }

  ngOnInit() {
  }

}
