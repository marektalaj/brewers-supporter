import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BasicAuthHtppInterceptorService } from './service/basic-auth-http-interceptor.service';
import { RegisterComponent } from './register/register.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { RefactometerComponent } from './calculators/refactometer/refactometer.component';
import { EfficiencyComponent } from './calculators/efficiency/efficiency.component';
import { AlcoholComponent } from './calculators/alcohol/alcohol.component';
import { CorrectionComponent } from './calculators/correction/correction.component';
import { AddRecipeComponent } from './recipes/add-recipe/add-recipe.component';
import { RecipesComponent } from './recipes/recipes/recipes.component';
import { RecipeDetailsComponent } from './recipes/recipe-details/recipe-details.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoutComponent,
    HeaderComponent,
    HomeComponent,
    RegisterComponent,
    RefactometerComponent,
    EfficiencyComponent,
    AlcoholComponent,
    CorrectionComponent,
    AddRecipeComponent,
    RecipesComponent,
    RecipeDetailsComponent,
  ],
  imports: [
    HttpClientModule,
    NgSelectModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [
    {  
      provide:HTTP_INTERCEPTORS, useClass:BasicAuthHtppInterceptorService, multi:true 
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
