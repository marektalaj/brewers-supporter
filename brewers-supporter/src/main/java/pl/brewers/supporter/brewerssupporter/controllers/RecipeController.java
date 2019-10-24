package pl.brewers.supporter.brewerssupporter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.brewers.supporter.brewerssupporter.model.Recipe;
import pl.brewers.supporter.brewerssupporter.services.RecipeService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping("/{username}")
    public Recipe saveRecipe(@RequestBody Recipe recipe, @PathVariable String username) {
        return recipeService.saveRecipe(recipe, username);
    }

    @PutMapping("/edit/{username}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable String username) {
        return recipeService.update(recipe, username);
    }

    @GetMapping("/id/{id}")
    public Recipe getRecipeById(@PathVariable String id) {
        return recipeService.getRecipeById(Long.parseLong(id));
    }

    @GetMapping("/username/{username}")
    public List<Recipe> getRecipeByUsername(@PathVariable String username) {
        return recipeService.getRecipeByUsername(username);
    }

}
