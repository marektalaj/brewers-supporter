import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BrewingParams } from '../model/BrewingParams';
import { Batch } from '../model/Batch';

@Injectable({
  providedIn: 'root'
})
export class BatchServiceService {
  baseUrl: string = 'http://localhost:8080/batches';

  constructor(private httpClient: HttpClient) { }

  saveBatch(recipeId, username, brewingParams: BrewingParams) {
    return this.httpClient.post<Batch>(this.baseUrl + '/' + recipeId + '/' + username, brewingParams);
  }

  updateBatch(batchId, brewingParams: BrewingParams) {
    return this.httpClient.put<Batch>(this.baseUrl + '/edit/' + batchId, brewingParams);
  }

  getRecipesByUsername(username) {
    return this.httpClient.get<Batch[]>(this.baseUrl + '/' + username);
  }

  getBatchById(id) {
    return this.httpClient.get<Batch>(this.baseUrl + '/id/' + id);
  }

}
