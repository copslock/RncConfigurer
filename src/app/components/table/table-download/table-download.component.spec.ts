import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableDownloadComponent } from './table-download.component';

describe('TableDownloadComponent', () => {
  let component: TableDownloadComponent;
  let fixture: ComponentFixture<TableDownloadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableDownloadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableDownloadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
