import { Component, OnInit } from '@angular/core';
import { Recipe } from 'src/app/model/Recipe';
import { BatchServiceService } from 'src/app/service/batch-service.service';
import { RecipeService } from 'src/app/service/recipe-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BrewingParams } from 'src/app/model/BrewingParams';
import { dashCaseToCamelCase } from '@angular/compiler/src/util';

@Component({
  selector: 'app-brew-batch',
  templateUrl: './brew-batch.component.html',
  styleUrls: ['./brew-batch.component.css']
})
export class BrewBatchComponent implements OnInit {
  id: string;
  recipe: Recipe;
  editing: boolean = false;
  brewingParams: BrewingParams = new BrewingParams;


  constructor(private activRoute: ActivatedRoute,
    private recipeServ: RecipeService,
    private batchService: BatchServiceService,
    private router: Router) { }

  ngOnInit() {
    if (this.id = this.activRoute.snapshot.paramMap.get('recipeId')) {
      this.recipeServ.getRecipeById(this.id).subscribe(
        data => {
          this.recipe = data;
        }
      );
    } else if (this.id = this.activRoute.snapshot.paramMap.get('batchId')) {
      this.batchService.getBatchById(this.id).subscribe(
        data => {
          this.recipe = data.recipe;
          this.brewingParams.originalGravity = data.originalGravity;
          this.brewingParams.amount = data.amountAfterBoiling;
          this.brewingParams.amountBeforeBoiling = data.amountBeforeBoiling;
          this.brewingParams.finalGravity = data.finalGravity;
          this.brewingParams.notes = data.notes;
          this.brewingParams.fermentationTime = data.fermentationTime;
          this.brewingParams.gravityBeforeBoiling = data.gravityBeforeBoiling;
          this.editing = true;
        }
      )
    }

  }

  brewBatch() {
    if (!this.brewingParams.originalGravity || !this.brewingParams.amount) {
      window.alert('Usupełnij wymagane pola');
      return;
    }
    if (!this.editing) {
      this.batchService.saveBatch(this.recipe.id, sessionStorage.getItem('username'), this.brewingParams).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['batches', data.id, 'details']);
        },
        error => {
        }

      );
    } else {
      this.batchService.updateBatch(this.id, this.brewingParams).subscribe(
        data => {
          this.router.navigate(['batches', data.id, 'details'])
        }

      )
    }
  }

}
