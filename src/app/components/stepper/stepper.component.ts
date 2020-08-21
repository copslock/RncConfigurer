import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FileUploader} from 'ng2-file-upload';
import {MatTableDataSource} from '@angular/material/table';
import {TableComponent} from '../table/table-main/table.component';
import {DownloadService} from '../../services/download/download.service';


const URL = 'http://localhost:4201/api/v1/rnc-maximo-table/upload';

@Component({
  selector: 'app-stepper',
  templateUrl: './stepper.component.html',
  styleUrls: ['./stepper.component.scss']
})
export class StepperComponent implements OnInit {

  filename = 'RncMaximoTable1.csv';
  lastFileName = 'RncMaximoTable1.csv';

  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  isDivVisible = false;
  dataSource = new MatTableDataSource<string>();

  public uploader: FileUploader = new FileUploader({ url: URL, itemAlias: 'file' });

  // tslint:disable-next-line:variable-name
  constructor(private _formBuilder: FormBuilder, public service: DownloadService) {}

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });

    // this.uploader.onAfterAddingFile = (file) => { file.withCredentials = false; this.isDivVisible = true; };

    this.uploader.onBeforeUploadItem = (file) => {
      this.lastFileName = this.filename;
      this.filename = file._file.name;
    };
    this.uploader.onAfterAddingFile = (file) => { file.withCredentials = false; };
    this.uploader.onCompleteItem = (item: any, response: any, status: any, headers: any) => {

      if (JSON.parse(response).status) {
        this.service.getMapTable(this.filename).subscribe(data => {

          this.dataSource = data;
          console.log(this.filename);
          console.log(data);
          this.isDivVisible = true;
          alert('File uploaded successfully');

        });
      } else {
        alert('validation was not passed, choose another file');
      }

    };
  }

  getTable() {
    this.isDivVisible = true;
  }

  browse() {
    document.getElementById('selectedFile').click();
  }

}
