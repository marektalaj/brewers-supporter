import { Injectable } from '@angular/core';
import { Malt } from '../model/Malt';
import { Hoop } from '../model/Hoop';
import { Yeast } from '../model/Yeasts';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {
  baseUrl: string = 'http://localhost:8080/ingredients';

  constructor(private httpClient:HttpClient) { }

  malts(){
    return this.httpClient.get<Malt[]>(this.baseUrl + '/malts' );
  }
  hoops(){
    return this.httpClient.get<Hoop[]>(this.baseUrl + '/hoops' );
  }
  yeasts(){
    return this.httpClient.get<Yeast[]>(this.baseUrl + '/yeasts' );
  }
}
