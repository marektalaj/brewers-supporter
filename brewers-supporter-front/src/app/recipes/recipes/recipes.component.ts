import { Component, OnInit } from '@angular/core';
import { RecipeService } from 'src/app/service/recipe-service.service';
import { Recipe } from 'src/app/model/Recipe';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {
  recipes: Recipe[]

  constructor(private recipeService: RecipeService,
    private router: Router) { }

  ngOnInit() {
    this.recipeService.getRecipeByUsername(sessionStorage.getItem('username')).subscribe(
      data => {
        this.recipes = data;
      },
      error => {
        window.alert("nie udało się wczytac" );
      }
    )
  }

  goToDetails(id){
    this.router.navigate(['recipes/details', id]);
  }

}
