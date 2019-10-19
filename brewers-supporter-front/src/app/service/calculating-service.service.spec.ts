import { TestBed } from '@angular/core/testing';

import { CalculatingServiceService } from './calculating-service.service';

describe('CalculatingServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CalculatingServiceService = TestBed.get(CalculatingServiceService);
    expect(service).toBeTruthy();
  });
});
