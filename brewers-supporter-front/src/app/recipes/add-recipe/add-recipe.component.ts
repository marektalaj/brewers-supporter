import { Component, OnInit } from '@angular/core';
import { IngredientService } from 'src/app/service/ingredient-service.service';
import { Malt } from 'src/app/model/Malt';
import { Hoop } from 'src/app/model/Hoop';
import { Yeast } from 'src/app/model/Yeasts';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {
  malts: Observable<Malt[]>;
  hoops: Hoop[];
  yeasts: Yeast[];
  malt: Malt;

  constructor(private service: IngredientService) { }

  ngOnInit() {
    this.malts = this.service.malts();
  }

}
