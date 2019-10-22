package pl.brewers.supporter.brewerssupporter.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.brewers.supporter.brewerssupporter.model.Recipe;
import pl.brewers.supporter.brewerssupporter.repositories.RecipeRepository;
import pl.brewers.supporter.brewerssupporter.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final JwtUserDetailsService userService;

    public Recipe saveRecipe(Recipe recipe, String username) {
        recipe.setAuthor(userService.getUserByUsername(username));
        return recipeRepository.save(recipe);
    }

    public Recipe update(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public List<Recipe> getRecipeByUsername(String username) {
        return recipeRepository.findByAuthor(userRepository.findByUsername(username));
    }

}
