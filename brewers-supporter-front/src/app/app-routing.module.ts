import { AlcoholComponent } from './calculators/alcohol/alcohol.component';
import { CorrectionComponent } from './calculators/correction/correction.component';
import { EfficiencyComponent } from './calculators/efficiency/efficiency.component';
import { RefactometerComponent } from './calculators/refactometer/refactometer.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HomeComponent } from './home/home.component';
import { AuthGuardService } from './service/auth-guard.service';
import { RegisterComponent } from './register/register.component';
import { AddRecipeComponent } from './recipes/add-recipe/add-recipe.component';
import { RecipesComponent } from './recipes/recipes/recipes.component';
import { RecipeDetailsComponent } from './recipes/recipe-details/recipe-details.component';
import { BrewBatchComponent } from './batches/brew-batch/brew-batch.component';
import { BatchesComponent } from './batches/batches/batches.component';
import { BatchDetailsComponent } from './batches/batch-details/batch-details.component';
import { PrimingComponent } from './calculators/priming/priming.component';



const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuardService]},
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'register', component: RegisterComponent},
  { path: 'recipes', component: RecipesComponent},
  { path: 'batches/:recipeId/brew', component: BrewBatchComponent},
  { path: 'batches/:batchId/edit', component: BrewBatchComponent},
  { path: 'batches/:id/details', component: BatchDetailsComponent},
  { path: 'batches', component: BatchesComponent},
  { path: 'recipes/add', component: AddRecipeComponent},
  { path: 'recipes/:id/edit', component: AddRecipeComponent},
  { path: 'recipes/:id/details', component: RecipeDetailsComponent},
  { path: 'calculator/refactometer', component: RefactometerComponent},
  { path: 'calculator/efficiency', component: EfficiencyComponent},
  { path: 'calculator/correction', component: CorrectionComponent},
  { path: 'calculator/alcohol', component: AlcoholComponent},
  { path: 'calculator/priming', component: PrimingComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
