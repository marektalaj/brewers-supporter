package pl.brewers.supporter.brewerssupporter.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.brewers.supporter.brewerssupporter.dto.BrewingParamsDTO;
import pl.brewers.supporter.brewerssupporter.model.User;
import pl.brewers.supporter.brewerssupporter.model.Batch;
import pl.brewers.supporter.brewerssupporter.model.Recipe;
import pl.brewers.supporter.brewerssupporter.repositories.BatchRepository;
import pl.brewers.supporter.brewerssupporter.repositories.RecipeRepository;
import pl.brewers.supporter.brewerssupporter.repositories.UserRepository;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final RecipeRepository recipeRepository;
    private final BatchRepository batchRepository;
    private final UserRepository authorRepository;

    public Batch transformRecipe(BrewingParamsDTO brewingParams, Long recipeId, Long authorId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElse(null);
        User author = authorRepository.findById(authorId.intValue()).orElse(null);

        Batch newBatch = Batch.builder()
                .gravityBeforeBoiling(brewingParams.getGravityBeforeBoiling())
                .amountBeforeBoiling(brewingParams.getAmountBeforeBoiling())
                .author(author)
                .brewingDate(ZonedDateTime.now())
                .notes(brewingParams.getNotes())
                .originalGravity(brewingParams.getOriginalGravity())
                .recipe(recipe)
                .build();
        return batchRepository.save(newBatch);
    }
}
