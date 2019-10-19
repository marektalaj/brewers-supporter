import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CalculatingServiceService {
const baseUrl='http://localhost:8080/calculator/';

  constructor(private httpClient:HttpClient) { }

  refactometerCorrection(originalGravity, measuredGravity){
    return this.httpClient.post(this.baseUrl + 'refactometer', {originalGravity, measuredGravity} );
  }

  wortCorrection(amount, measured, wanted){
    return this.httpClient.post(this.baseUrl + 'correction', {amount, measured, wanted} );
  }

  alcoholCalculation(originalGravity, finalGravity){
    return this.httpClient.post(this.baseUrl + 'alcohol', {originalGravity, finalGravity} );
  }

  mashEfficiency(amount, gravity, maltAmount){
    return this.httpClient.post(this.baseUrl + 'efficiency', {amount, gravity, maltAmount} );
  }

}
