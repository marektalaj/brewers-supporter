package pl.brewers.supporter.brewerssupporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.brewers.supporter.brewerssupporter.model.Recipe;
import pl.brewers.supporter.brewerssupporter.repositories.RecipeRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private RecipeRepository recipeRepository;

    @Autowired
    public DataLoader(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void run(ApplicationArguments args) {
        recipeRepository.save(Recipe.builder().name("sosnowe").build());
        recipeRepository.save(Recipe.builder().name("debowe").build());
        recipeRepository.save(Recipe.builder().name("beczkowe").build());
        recipeRepository.save(Recipe.builder().name("tyskie").build());
    }
}
