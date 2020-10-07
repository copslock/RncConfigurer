import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {FileUploader} from 'ng2-file-upload';
import {Router} from '@angular/router';
import {DownloadService} from '../../../services/download/download.service';
import {TableComponent} from '../table-main/table.component';

const URL = 'http://localhost:8089/api/v1/rnc/upload';

@Component({
  selector: 'app-table-clone',
  templateUrl: './table-clone.component.html',
  styleUrls: ['./table-clone.component.scss']
})
export class TableCloneComponent implements OnInit {

  static filename = 'RncMaximoTable1.csv';
  static lastFileName = 'RncMaximoTable1.csv';

  @ViewChild('scrollTo', {static: false}) MyProp: ElementRef;

  headers: Array<any> = [];

  displayedColumns: string[] = ['Rehom.Order', 'BSC', 'Site', 'Cell', 'LON', 'LAT', 'LAC', 'CI', 'New BSC', 'New LAC', 'New CI', 'New Ura', 'New_RBSID_1', 'New_RBSID_2'];

  @Input()
  dataSource = new MatTableDataSource<string>();

  form: FormGroup;

  isUploaded = false;

  // to send file to back end
  fileData: File = null;
  previewUrl: any = null;


  // public uploader: FileUploader = new FileUploader({ url: URL, itemAlias: 'file' });

  constructor(
    private downloadService: DownloadService,
    public fb: FormBuilder,
    public router: Router,
  ) {}

  ngOnInit() {
    // this.uploader.onBeforeUploadItem = (file) => {
    //   TableCloneComponent.lastFileName = TableCloneComponent.filename;
    //   TableCloneComponent.filename = file._file.name;
    //   console.log(file._file.name);
    // };
    // this.uploader.onAfterAddingFile = (file) => { file.withCredentials = false; this.isUploaded = true; };
    // this.uploader.onCompleteItem = (item: any, response: any, status: any, headers: any) => {
    //   this.downloadService.getMapTable(TableCloneComponent.filename).subscribe(data => {
    //
    //     if (!data === false) {
    //       this.dataSource = data;
    //       console.log(TableCloneComponent.filename);
    //       console.log(data);
    //     } else {
    //       alert('validation was not passed');
    //     }
    //
    //   });
    //   alert('File uploaded successfully');
    // };

    this.form = this.fb.group({
      search: new FormControl('')
    });

  }


  scroll() {
    this.MyProp.nativeElement.scrollIntoView({ behavior: 'smooth', block: 'start' });
  }

  downloadFile() {
    return this.downloadService.getFile().subscribe(data => {
      this.saveFile(data, data.headers.get('content-disposition'));
    }, error => {
      console.log('Error during download file');
      console.log(error);
    }), () => console.log('OK');
  }

  saveFile(data: Blob, filename: string) {
    const name = filename.split('"');
    const blob = new Blob([data], { type: 'text/csv' });
    const a = document.createElement('a');
    a.href = window.URL.createObjectURL(blob);
    a.download = name[1];
    a.click();
  }

  fileProgress(fileInput: any) {
    this.fileData = fileInput.target.files[0] as File;
    this.preview();
  }

  preview() {
    // Show preview
    const mimeType = this.fileData.type;
    if (mimeType.match('/image\/*/') == null) {
      return;
    }

    const reader = new FileReader();
    reader.readAsDataURL(this.fileData);
    reader.onload = (event) => {
      this.previewUrl = reader.result;
    };
  }

}
