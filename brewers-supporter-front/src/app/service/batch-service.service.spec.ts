import { TestBed } from '@angular/core/testing';

import { BatchServiceService } from './batch-service.service';

describe('BatchServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BatchServiceService = TestBed.get(BatchServiceService);
    expect(service).toBeTruthy();
  });
});
