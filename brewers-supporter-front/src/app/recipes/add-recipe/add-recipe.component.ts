import { Component, OnInit } from '@angular/core';
import { IngredientService } from 'src/app/service/ingredient-service.service';
import { Malt } from 'src/app/model/Malt';
import { Hoop } from 'src/app/model/Hoop';
import { Yeast } from 'src/app/model/Yeasts';
import { Observable } from 'rxjs';
import { MaltingIngredient } from 'src/app/model/MaltingIngredient';
import { Recipe } from 'src/app/model/Recipe';
import { AdditionalIngredient } from 'src/app/model/AdditionalIngredient';
import { HoopingIngredient } from 'src/app/model/HoopingIngredient';
import { YeastAsIngredient } from 'src/app/model/YeastAsIngredient';
import { RecipeService } from 'src/app/service/recipe-service.service';

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {
  malts: Observable<Malt[]>;
  hoops: Observable<Hoop[]>;
  yeasts: Observable<Yeast[]>;
  malt: Malt;
  yeastAsIngredient: YeastAsIngredient = new YeastAsIngredient;
  maltingIngredients: Array<MaltingIngredient> = [];
  newMaltingIngredient: MaltingIngredient = new MaltingIngredient();
  additionalIngredients: Array<AdditionalIngredient> = [];
  newAdditionalIngredient: AdditionalIngredient = new AdditionalIngredient();
  hoopingIngredients: Array<HoopingIngredient> = [];
  newHoopingIngredient: HoopingIngredient = new HoopingIngredient();
  recipe: Recipe = new Recipe;


  constructor(private service: IngredientService,
    private recipeService: RecipeService) { }

  addFieldValue() {
    this.maltingIngredients.push(this.newMaltingIngredient)
    this.newMaltingIngredient = new MaltingIngredient();
    this.recipe.maltingIngredients = this.maltingIngredients;

  }

  deleteFieldValue(index) {
    this.maltingIngredients.splice(index, 1);
  }

  addFieldValueHoop() {
    this.hoopingIngredients.push(this.newHoopingIngredient)
    this.newHoopingIngredient = new HoopingIngredient();
    this.recipe.hoopingIngredients = this.hoopingIngredients;

  }

  deleteFieldValueHoop(index) {
    this.hoopingIngredients.splice(index, 1);
  }

  addFieldValueAditional() {
    this.additionalIngredients.push(this.newAdditionalIngredient)
    this.newAdditionalIngredient = new AdditionalIngredient();
    this.recipe.additionalIngredients = this.additionalIngredients;
  }

  deleteFieldValueAditional(index) {
    this.additionalIngredients.splice(index, 1);
  }

  ngOnInit() {
    this.malts = this.service.malts();
    this.hoops = this.service.hoops();
    this.yeasts = this.service.yeasts();
  }


  saveRecipe() {
    this.recipe.yeast = this.yeastAsIngredient;
    this.recipeService.saveRecipe(this.recipe, sessionStorage.getItem('username')).subscribe(
      data =>{
        window.alert("good job")
      },
      error => {
        window.alert("good job")
      }
      
    )
  }
}
