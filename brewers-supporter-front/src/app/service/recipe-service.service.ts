import { Injectable } from '@angular/core';
import { Recipe } from '../model/Recipe';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecipeServiceService {
  baseUrl: string = 'http://localhost:8080/recipe';

  constructor(private httpClient:HttpClient) { }

  saveRecipe(recipe: Recipe){
    return this.httpClient.post<Recipe>(this.baseUrl, recipe );
  }

  updateRecipe(recipe: Recipe){
    return this.httpClient.put<Recipe>(this.baseUrl, recipe );
  }

  getRecipeById(id){
    return this.httpClient.get<Recipe>(this.baseUrl+'/'+id)
  }

  getRecipeByUsername(username){
    return this.httpClient.get<Recipe[]>(this.baseUrl+'/'+username)
  }
}
