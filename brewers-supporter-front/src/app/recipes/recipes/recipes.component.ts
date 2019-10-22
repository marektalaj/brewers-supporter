import { Component, OnInit } from '@angular/core';
import { RecipeService } from 'src/app/service/recipe-service.service';
import { Recipe } from 'src/app/model/Recipe';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {
  recipes: Recipe[]

  constructor(private recipeService: RecipeService) { }

  ngOnInit() {
    this.recipeService.getRecipeByUsername(sessionStorage.getItem('username')).subscribe(
      data => {
        console.log(data)
        this.recipes = data;
        this.recipeService.getRecipeById(this.recipes[0].id).subscribe(
          data => {
            console.log(data)
          }
        )

      },
      error => {
        window.alert("nie udało się" );
      }
    )
  }

}
