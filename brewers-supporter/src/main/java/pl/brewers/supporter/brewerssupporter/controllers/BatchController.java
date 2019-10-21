package pl.brewers.supporter.brewerssupporter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.brewers.supporter.brewerssupporter.dto.BrewingParamsDTO;
import pl.brewers.supporter.brewerssupporter.model.Batch;
import pl.brewers.supporter.brewerssupporter.services.BatchService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BatchController {
    private final BatchService batchService;

    @PostMapping(value = "/batch/{recipeId}/{username}")
    public Batch saveBatch(@RequestBody BrewingParamsDTO brewingParamsDTO,
                           @PathVariable Long recipeId,
                           @PathVariable String username) {
        return batchService.transformRecipe(brewingParamsDTO, recipeId, username);
    }

    @PutMapping(value = "batch/{batchId}")
    public Batch updateBatch(@RequestBody BrewingParamsDTO brewingParamsDTO,
                             @PathVariable Long batchId) {
        return batchService.updateBatch(brewingParamsDTO, batchId);
    }

    @GetMapping("/batches/{username}")
    public List<Batch> getRecipeByUsername(@PathVariable String username) {
        return batchService.getRecipeByUsername(username);
    }


}
