import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BrewBatchComponent } from './brew-batch.component';

describe('BrewBatchComponent', () => {
  let component: BrewBatchComponent;
  let fixture: ComponentFixture<BrewBatchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BrewBatchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BrewBatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
