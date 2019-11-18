package pl.brewers.supporter.brewerssupporter.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.brewers.supporter.brewerssupporter.dto.HoopingDataRequestDTO;
import pl.brewers.supporter.brewerssupporter.dto.MashDataRequestDTO;
import pl.brewers.supporter.brewerssupporter.model.Recipe;
import pl.brewers.supporter.brewerssupporter.repositories.BatchRepository;
import pl.brewers.supporter.brewerssupporter.repositories.RecipeRepository;
import pl.brewers.supporter.brewerssupporter.repositories.UserRepository;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final JwtUserDetailsService userService;
    private final CalculatingService calculatingService;
    private final BatchRepository batchRepository;

    public Recipe saveRecipe(Recipe recipe, String username) {
        setRecipeNeededVariables(recipe, username);
        recipe.setCreationDateTime(ZonedDateTime.now());
        return recipeRepository.save(recipe);
    }

    public Recipe update(Recipe recipe, String username) {
        setRecipeNeededVariables(recipe, username);
        return recipeRepository.save(recipe);
    }

    private void setRecipeNeededVariables(Recipe recipe, String username) {
        recipe.setAuthor(userService.getUserByUsername(username));
        recipe.setOriginalGravity(calculatingService.calculateMashData(MashDataRequestDTO.builder().amount(recipe.getAmount()).maltingIngredients(recipe.getMaltingIngredients()).build()).getGravity());
        recipe.setIbu(calculatingService.calculateIBU(HoopingDataRequestDTO.builder().amount(recipe.getAmount()).gravity(recipe.getOriginalGravity()).hoopingIngredients(recipe.getHoopingIngredients()).build()).getIbu());
        recipe.setLastEditDateTime(ZonedDateTime.now());
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public List<Recipe> getRecipeByUsername(String username) {
        return recipeRepository.findByAuthor(userRepository.findByUsername(username));
    }

    public boolean deleteRecipe(Long recipeId) {
        if(batchRepository.findByRecipe(recipeRepository.findById(recipeId).get()).isPresent()){
            return false;
        }else{
            recipeRepository.deleteById(recipeId);
            return true;
        }
    }
}
