import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableCloneComponent } from './table-clone.component';

describe('TableCloneComponent', () => {
  let component: TableCloneComponent;
  let fixture: ComponentFixture<TableCloneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableCloneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableCloneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
