import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Location} from '@angular/common';
import {DownloadService} from '../../../services/download/download.service';
import {TableComponent} from '../table-main/table.component';

@Component({
  selector: 'app-table-download',
  templateUrl: './table-download.component.html',
  styleUrls: ['./table-download.component.scss']
})
export class TableDownloadComponent implements OnInit {

  count = 0;
  result = false;

  constructor(private router: Router, private location: Location, public service: DownloadService) {
    // document.onload = () => {
      this.run(this.count);
    // };
  }

  ngOnInit() {
    this.service.inputChanges(TableComponent.filename).then(data => {
      console.log(data);
      TableComponent.objects = data;
      this.count = 100;
    });
  }

  run(end: number) {
    setTimeout(() => { if (end < 100) { this.count++; this.run(this.count + 1); } else { this.router.navigate(['table']); }  }, 100);
  }

}
