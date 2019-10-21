import { TestBed } from '@angular/core/testing';

import { CalculatingService } from './calculating-service.service';

describe('CalculatingServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CalculatingService = TestBed.get(CalculatingService);
    expect(service).toBeTruthy();
  });
});
