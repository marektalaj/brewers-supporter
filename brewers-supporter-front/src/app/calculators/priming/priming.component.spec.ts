import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimingComponent } from './priming.component';

describe('PrimingComponent', () => {
  let component: PrimingComponent;
  let fixture: ComponentFixture<PrimingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrimingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrimingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
