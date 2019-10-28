import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { Router } from '@angular/router';
import { RecipeService } from 'src/app/service/recipe-service.service';
import { Recipe } from 'src/app/model/Recipe';
import { CalculatingService } from 'src/app/service/calculating-service.service';

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css']
})
export class RecipeDetailsComponent implements OnInit {
  id: string;
  recipe: Recipe;

  constructor(private activRoute: ActivatedRoute,
          private recipeServ: RecipeService,
          private calcServ: CalculatingService) { }

  ngOnInit() {
    this.id = this.activRoute.snapshot.paramMap.get('id');
    this.recipeServ.getRecipeById(this.id).subscribe(
      data =>{
        this.recipe = data;
      }
    );
  }

}
