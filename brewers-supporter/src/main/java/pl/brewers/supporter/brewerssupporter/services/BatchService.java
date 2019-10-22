package pl.brewers.supporter.brewerssupporter.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.brewers.supporter.brewerssupporter.dto.BrewingParamsDTO;
import pl.brewers.supporter.brewerssupporter.dto.HoopingDataRequestDTO;
import pl.brewers.supporter.brewerssupporter.model.Batch;
import pl.brewers.supporter.brewerssupporter.model.Recipe;
import pl.brewers.supporter.brewerssupporter.model.User;
import pl.brewers.supporter.brewerssupporter.repositories.BatchRepository;
import pl.brewers.supporter.brewerssupporter.repositories.RecipeRepository;
import pl.brewers.supporter.brewerssupporter.repositories.UserRepository;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final RecipeRepository recipeRepository;
    private final BatchRepository batchRepository;
    private final UserRepository userRepository;
    private final CalculatingService calculatingService;

    public Batch transformRecipe(BrewingParamsDTO brewingParams, Long recipeId, String username) {
        Recipe recipe = recipeRepository.findById(recipeId).orElse(Recipe.builder().build());
        User author = userRepository.findByUsername(username);

        Batch newBatch = buildBatch(Batch.builder(), brewingParams, recipe)
                .author(author)
                .recipe(recipe)
                .build();
        return batchRepository.save(newBatch);
    }

    private Batch.BatchBuilder buildBatch(Batch.BatchBuilder builder, BrewingParamsDTO brewingParams, Recipe recipe) {
        return builder
                .gravityBeforeBoiling(brewingParams.getGravityBeforeBoiling())
                .amountBeforeBoiling(brewingParams.getAmountBeforeBoiling())
                .brewingDate(ZonedDateTime.now())
                .notes(brewingParams.getNotes())
                .originalGravity(brewingParams.getOriginalGravity())
                .fermentationTime(brewingParams.getFermentationTime())
                .ibu(calculatingService.calculateIBU(
                        HoopingDataRequestDTO.builder()
                                .gravity(brewingParams.getOriginalGravity())
                                .amount(brewingParams.getAmount())
                                .hoopingIngredients(recipe.getHoopingIngredients())
                                .build()
                ).getIbu())
                .finalGravity(brewingParams.getFinalGravity());
    }

    public List<Batch> getRecipeByUsername(String username) {
        return batchRepository.findByAuthor(userRepository.findByUsername(username));
    }

    public Batch updateBatch(BrewingParamsDTO brewingParams, Long batchId) {
        Batch batch = batchRepository.findById(batchId).orElse(Batch.builder().build());
        return batchRepository.save(buildBatch(batch.toBuilder(), brewingParams, batch.getRecipe())
                .build());
    }
}
