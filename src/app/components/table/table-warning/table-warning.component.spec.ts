import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableWarningComponent } from './table-warning.component';

describe('TableWarningComponent', () => {
  let component: TableWarningComponent;
  let fixture: ComponentFixture<TableWarningComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableWarningComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableWarningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
