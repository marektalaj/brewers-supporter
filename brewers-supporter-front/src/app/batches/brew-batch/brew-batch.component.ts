import { Component, OnInit } from '@angular/core';
import { Recipe } from 'src/app/model/Recipe';
import { BatchServiceService } from 'src/app/service/batch-service.service';
import { RecipeService } from 'src/app/service/recipe-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BrewingParams } from 'src/app/model/BrewingParams';

@Component({
  selector: 'app-brew-batch',
  templateUrl: './brew-batch.component.html',
  styleUrls: ['./brew-batch.component.css']
})
export class BrewBatchComponent implements OnInit {
  id: string;
  recipe: Recipe;
  brewingParams: BrewingParams= new BrewingParams;


  constructor(private activRoute: ActivatedRoute,
    private recipeServ: RecipeService,
    private batchService: BatchServiceService,
    private router: Router) { }

  ngOnInit() {
    this.id = this.activRoute.snapshot.paramMap.get('recipeId');
    this.recipeServ.getRecipeById(this.id).subscribe(
      data =>{
        this.recipe = data;
        console.log(this.recipe.hoopingIngredients)
      }
    );
  }

  brewBatch(){
    this.batchService.saveBatch(this.recipe.id, sessionStorage.getItem('username'), this.brewingParams).subscribe(
      data => {
        console.log(data);
        this.router.navigate(['batches']);
      },
      error => {
      }
      
    );
  }

}
