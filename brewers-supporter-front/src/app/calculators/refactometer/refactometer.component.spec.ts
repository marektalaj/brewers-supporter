import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RefactometerComponent } from './refactometer.component';

describe('RefactometerComponent', () => {
  let component: RefactometerComponent;
  let fixture: ComponentFixture<RefactometerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RefactometerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RefactometerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
