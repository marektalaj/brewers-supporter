import { Injectable } from '@angular/core';
import { Recipe } from '../model/Recipe';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  baseUrl: string = 'http://localhost:8080/recipe';

  constructor(private httpClient: HttpClient) { }

  saveRecipe(recipe: Recipe, username) {
    return this.httpClient.post<Recipe>(this.baseUrl + '/' + username, recipe);
  }

  updateRecipe(recipe: Recipe, username) {
    return this.httpClient.put<Recipe>(this.baseUrl+ '/edit/' + username, recipe);
  }

  getRecipeById(id) {
    return this.httpClient.get<Recipe>(this.baseUrl + '/id/' + id)
  }

  getRecipeByUsername(username) {
    return this.httpClient.get<Recipe[]>(this.baseUrl + '/username/' + username)
  }

  deleteRecipe(id){
    return this.httpClient.delete(this.baseUrl +'/delete/'+id);
  }
}
