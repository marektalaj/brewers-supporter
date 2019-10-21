import { TestBed } from '@angular/core/testing';

import { IngredientService } from './ingredient-service.service';

describe('IngredientServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IngredientService = TestBed.get(IngredientService);
    expect(service).toBeTruthy();
  });
});
