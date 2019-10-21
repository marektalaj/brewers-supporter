package pl.brewers.supporter.brewerssupporter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.brewers.supporter.brewerssupporter.model.Recipe;
import pl.brewers.supporter.brewerssupporter.services.RecipeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    @PostMapping(value = "/recipe")
    public Recipe saveRecipe(@RequestBody Recipe recipe){
        return recipeService.saveRecipe(recipe);
    }

    @PutMapping(value = "/recipe")
    public Recipe updateRecipe(@RequestBody Recipe recipe){
        return recipeService.saveRecipe(recipe);
    }

    @GetMapping("/recipe/{id}")
    public Recipe getRecipeById(@PathVariable String id){
        return recipeService.getRecipeById(Long.parseLong(id));
    }

    @GetMapping("/recipes/{username}")
    public List<Recipe> getRecipeByUsername(@PathVariable String username){
        return  recipeService.getRecipeByUsername(username);
    }

}
