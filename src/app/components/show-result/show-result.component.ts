import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {DownloadService} from '../../services/download/download.service';

@Component({
  selector: 'app-show-result',
  templateUrl: './show-result.component.html',
  styleUrls: ['./show-result.component.scss']
})
export class ShowResultComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ShowResultComponent>, @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {

  }


}
